package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentConfigurationDao;
import com.siemens.brownfield.femanagement.dto.EquipmentConfigurationDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentConfiguration;
import com.siemens.brownfield.femanagement.service.EquipmentConfigurationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EquipmentConfigurationServiceImpl implements EquipmentConfigurationService {

    private final CdEquipmentConfigurationDao cdEquipmentConfigurationDao;

    public EquipmentConfigurationServiceImpl(CdEquipmentConfigurationDao cdEquipmentConfigurationDao) {
        this.cdEquipmentConfigurationDao = cdEquipmentConfigurationDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteConfiguration(List<Integer> ids, Integer equipmentId) {

        int result = cdEquipmentConfigurationDao.softDeleteConfigurations(ids, equipmentId);
        return result == 1;
    }

    @Override
    public Boolean addConfiguration(EquipmentConfigurationDto configurationDto) {
        CdEquipmentConfiguration equipmentConfiguration = CdEquipmentConfiguration.from(configurationDto);
        int result = cdEquipmentConfigurationDao.insert(equipmentConfiguration);
        return result == 1;
    }

    @Override
    public List<EquipmentConfigurationDto> getConfigurations(Integer equipmentId) {
        return cdEquipmentConfigurationDao.getEquipmentConfigurationList(equipmentId).stream()
                .map(EquipmentConfigurationDto::from).collect(Collectors.toList());
    }
}
