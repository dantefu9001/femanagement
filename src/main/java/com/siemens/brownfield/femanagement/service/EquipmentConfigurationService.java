package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.EquipmentConfigurationDto;

import java.util.List;

public interface EquipmentConfigurationService {

    Boolean deleteConfiguration(List<Integer> ids, Integer equipmentId);

    Boolean addConfiguration(EquipmentConfigurationDto configurationDto);

    List<EquipmentConfigurationDto> getConfigurations(Integer equipmentId);
}
