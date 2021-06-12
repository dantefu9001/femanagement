package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentManagementSummaryDao;
import com.siemens.brownfield.femanagement.dto.EquipmentSummaryDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentManagementSummary;
import com.siemens.brownfield.femanagement.service.EquipmentsSummaryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EquipmentsSummaryServiceImpl implements EquipmentsSummaryService {

    private final CdEquipmentManagementSummaryDao equipmentManagementSummaryDao;

    public EquipmentsSummaryServiceImpl(CdEquipmentManagementSummaryDao equipmentManagementSummaryDao) {
        this.equipmentManagementSummaryDao = equipmentManagementSummaryDao;
    }

    @Override
    public List<EquipmentSummaryDto> getSummaryList(String type, String summary) {
        List<EquipmentSummaryDto> summaryDtos = equipmentManagementSummaryDao.getEquipmentManagementSummary(type, summary)
                .stream().map(equipmentSummary -> EquipmentSummaryDto.builder()
                        .id(equipmentSummary.getId())
                        .type(CdEquipmentManagementSummary.EquipmentManagementSummary.getValueByType(equipmentSummary.getType()))
                        .summary(equipmentSummary.getSummary())
                        .summaryTime(Objects.nonNull(equipmentSummary.getSummaryTime())
                                ? new SimpleDateFormat("yyyy-MM-dd").format(equipmentSummary.getSummaryTime())
                                : "")
                        .group(equipmentSummary.getGroup())
                        .person(equipmentSummary.getPerson())
                        .build()).collect(Collectors.toList());
        return summaryDtos;
    }

    @Override
    public EquipmentSummaryDto getEquipmentById(Integer id) {
        return null;
    }

    @Override
    public Boolean addEquipmentSummary(EquipmentSummaryDto equipmentSummaryDto) {
        try {
            equipmentManagementSummaryDao.insertSelective(CdEquipmentManagementSummary.from(equipmentSummaryDto));
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
