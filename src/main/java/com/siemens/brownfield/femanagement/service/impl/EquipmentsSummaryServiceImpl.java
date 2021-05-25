package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentManagementSummaryDao;
import com.siemens.brownfield.femanagement.dto.EquipmentSummaryDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentManagementSummary;
import com.siemens.brownfield.femanagement.service.EquipmentsSummaryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EquipmentsSummaryServiceImpl implements EquipmentsSummaryService {

    private final CdEquipmentManagementSummaryDao equipmentManagementSummaryDao;

    public EquipmentsSummaryServiceImpl(CdEquipmentManagementSummaryDao equipmentManagementSummaryDao) {
        this.equipmentManagementSummaryDao = equipmentManagementSummaryDao;
    }

    @Override
    public List<EquipmentSummaryDto> getSummaryList() {
        return equipmentManagementSummaryDao.getEquipmentManagementSummary().stream().map(equipmentSummary-> EquipmentSummaryDto.builder()
                .summary(equipmentSummary.getSummary())
                .summaryTime(equipmentSummary.getSummaryTime())
                .group(1)
                .person(1)
                .build()).collect(Collectors.toList());
    }

    @Override
    public EquipmentSummaryDto getEquipmentById(Integer id) {
        return null;
    }

    @Override
    public Boolean addEquipmentSummary(EquipmentSummaryDto equipmentSummaryDto) {
        try {
            equipmentManagementSummaryDao.insert(CdEquipmentManagementSummary.from(equipmentSummaryDto));
            return true;
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }

    @Override
    public EquipmentSummaryDto updateEquipmentSummary(EquipmentSummaryDto equipmentSummaryDto) {
        return null;
    }

    @Override
    public Boolean deleteEquipmentSummary(Integer id) {
        return null;
    }
}
