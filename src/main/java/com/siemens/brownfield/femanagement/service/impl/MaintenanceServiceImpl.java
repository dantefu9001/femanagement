package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.ProductionLineDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentGroupDao;
import com.siemens.brownfield.femanagement.dao.fe.CdMaintenanceDao;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.entity.bf.ProductionLine;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import com.siemens.brownfield.femanagement.service.MaintenanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final CdEquipmentDao cdEquipmentDao;
    private final CdMaintenanceDao cdMaintenanceDao;
    private final CdEquipmentGroupDao cdEquipmentGroupDao;
    private final ProductionLineDao productionLineDao;

    public MaintenanceServiceImpl(CdEquipmentDao cdEquipmentDao, CdMaintenanceDao cdMaintenanceDao, CdEquipmentGroupDao cdEquipmentGroupDao, ProductionLineDao productionLineDao) {
        this.cdEquipmentDao = cdEquipmentDao;
        this.cdMaintenanceDao = cdMaintenanceDao;
        this.cdEquipmentGroupDao = cdEquipmentGroupDao;
        this.productionLineDao = productionLineDao;
    }

    @Override
    public List<MaintenanceDto> getMaintenanceList(String start, String end, String equipment, String group) {
        List<MaintenanceDto> list= cdMaintenanceDao.getList(equipment, group, start, end).parallelStream().map(maintenance -> {
            MaintenanceDto dto = MaintenanceDto.from(maintenance);
            CdEquipment cdEquipment = cdEquipmentDao.selectByPrimaryKey(maintenance.getEquipment());
            if (Objects.nonNull(cdEquipment)) {
                dto.setEquipment(EquipmentDto.from(cdEquipment));
                ProductionLine productionLine = productionLineDao.selectByPrimaryKey(cdEquipment.getProductionLine());
                if (Objects.nonNull(productionLine)) {
                    dto.setProductionLine(ProductionLineDto.from(productionLine));
                }
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
    public void delete(MaintenanceDto dto) {
        CdMaintenance maintenance = CdMaintenance.from(dto);
        maintenance.setIsDelete("1");
        cdMaintenanceDao.updateByPrimaryKeySelective(maintenance);
    }
}
