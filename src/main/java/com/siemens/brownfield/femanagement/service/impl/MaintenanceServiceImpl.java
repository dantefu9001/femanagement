package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.PersonDao;
import com.siemens.brownfield.femanagement.dao.bf.ProcessDao;
import com.siemens.brownfield.femanagement.dao.bf.ProductionLineDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentGroupDao;
import com.siemens.brownfield.femanagement.dao.fe.CdMaintenanceDao;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import com.siemens.brownfield.femanagement.service.MaintenanceService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final CdEquipmentDao cdEquipmentDao;
    private final CdMaintenanceDao cdMaintenanceDao;
    private final CdEquipmentGroupDao cdEquipmentGroupDao;
    private final PersonDao personDao;
    private final ProductionLineDao productionLineDao;
    private final ProcessDao processDao;


    public MaintenanceServiceImpl(CdEquipmentDao cdEquipmentDao, CdMaintenanceDao cdMaintenanceDao, CdEquipmentGroupDao cdEquipmentGroupDao, PersonDao personDao, ProductionLineDao productionLineDao, ProcessDao processDao) {
        this.cdEquipmentDao = cdEquipmentDao;
        this.cdMaintenanceDao = cdMaintenanceDao;
        this.cdEquipmentGroupDao = cdEquipmentGroupDao;
        this.personDao = personDao;
        this.productionLineDao = productionLineDao;
        this.processDao = processDao;
    }

    @Override
    public List<MaintenanceDto> getMaintenanceList(String start, String end,String status, String equipment, String group) {
        if (Strings.isNotBlank((start))) {
            start = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.parse(start)));
        }
        if (Strings.isNotBlank(end)) {
            end = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.parse(end)));
        }
        List<MaintenanceDto> list = cdMaintenanceDao.getList(equipment, group,status, start, end).parallelStream().map(maintenance -> {
            MaintenanceDto dto = MaintenanceDto.from(maintenance);
            CdEquipment cdEquipment = cdEquipmentDao.selectByPrimaryKey(maintenance.getEquipment());
            if (Objects.nonNull(cdEquipment)) {
                dto.setEquipment(EquipmentDto.from(cdEquipment));
                Optional.of(productionLineDao.selectByPrimaryKey(cdEquipment.getProductionLine())).ifPresent(cdProductionLine -> dto.setProductionLine(ProductionLineDto.from(cdProductionLine)));
                Optional.of(processDao.selectByPrimaryKey(cdEquipment.getProcess())).ifPresent(cdProcess -> dto.setProcess(ProcessDto.from(cdProcess)));
                Optional.of(personDao.selectByPrimaryKey(cdEquipment.getResponsible())).ifPresent(cdPerson -> dto.setSubmitter(PersonDto.from(cdPerson)));
            }
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public void add(MaintenanceDto dto) {
        cdMaintenanceDao.insertSelective(CdMaintenance.from(dto));
    }

    @Override
    public void delete(List<Integer> ids) {
        if (ids.size()==0) {
            return;
        }
        cdMaintenanceDao.batchSoftDelete(ids);
    }

    @Override
    public void audit(List<Integer> ids) {
        if(ids.size()==0){
            return;
        }
        cdMaintenanceDao.audit(ids);
    }
}
