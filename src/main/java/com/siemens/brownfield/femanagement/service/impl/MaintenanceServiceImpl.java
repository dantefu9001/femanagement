package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.PersonDao;
import com.siemens.brownfield.femanagement.dao.bf.ProcessDao;
import com.siemens.brownfield.femanagement.dao.bf.ProductionLineDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentGroupDao;
import com.siemens.brownfield.femanagement.dao.fe.CdMaintenanceConsumptionDao;
import com.siemens.brownfield.femanagement.dao.fe.CdMaintenanceDao;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.dto.SparePartDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import com.siemens.brownfield.femanagement.entity.fe.CdMaintenanceConsumption;
import com.siemens.brownfield.femanagement.service.MaintenanceService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
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
    private final CdMaintenanceConsumptionDao cdMaintenanceConsumptionDao;


    public MaintenanceServiceImpl(CdEquipmentDao cdEquipmentDao, CdMaintenanceDao cdMaintenanceDao, CdEquipmentGroupDao cdEquipmentGroupDao, PersonDao personDao, ProductionLineDao productionLineDao, ProcessDao processDao, CdMaintenanceConsumptionDao cdMaintenanceConsumptionDao) {
        this.cdEquipmentDao = cdEquipmentDao;
        this.cdMaintenanceDao = cdMaintenanceDao;
        this.cdEquipmentGroupDao = cdEquipmentGroupDao;
        this.personDao = personDao;
        this.productionLineDao = productionLineDao;
        this.processDao = processDao;
        this.cdMaintenanceConsumptionDao = cdMaintenanceConsumptionDao;
    }

    @Override
    public List<MaintenanceDto> getMaintenanceList(String start, String end,String status, String equipment, String group) {
        if (Strings.isNotBlank((start))) {
            start = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.parse(start)));
        }
        if (Strings.isNotBlank(end)) {
            end = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.parse(end)));
        }
        return cdMaintenanceDao.getList(equipment, group,status, start, end).parallelStream().map(maintenance -> {
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
    }

    @Override
    public void add(MaintenanceDto dto) {
        CdMaintenance cdMaintenance = CdMaintenance.from(dto);
        cdMaintenance.setStatus("已提交");
        cdMaintenanceDao.insertSelective(cdMaintenance);
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

    @Override
    public void maintain(MaintenanceDto dto) {
        CdMaintenance cdMaintenance = CdMaintenance.maintainFrom(dto);
        cdMaintenance.setStatus("已维护");
        cdMaintenanceDao.updateByPrimaryKeySelective(cdMaintenance);
        if (Objects.nonNull(dto.getSpareParts()) && dto.getSpareParts().length > 0) {
            List<SparePartDto> dtos = Arrays.asList(dto.getSpareParts());
            List<CdMaintenanceConsumption> cdMaintenanceConsumptions = dtos.parallelStream().map(sparePartDto -> CdMaintenanceConsumption.builder()
                    .maintenance(dto.getId())
                    .sparePart(sparePartDto.getId())
                    .number(sparePartDto.getConsumption())
                    .build()).collect(Collectors.toList());
            cdMaintenanceConsumptions.forEach(cdMaintenanceConsumptionDao::insertSelective);
        }
    }
}
