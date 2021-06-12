package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.EquipmentSummaryDto;

import java.util.List;

public interface EquipmentsSummaryService {

    List<EquipmentSummaryDto> getSummaryList(String type, String description);

    EquipmentSummaryDto getEquipmentById(Integer id);

    Boolean addEquipmentSummary(EquipmentSummaryDto equipmentSummaryDto);

    EquipmentSummaryDto updateEquipmentSummary(EquipmentSummaryDto equipmentSummaryDto);

    Boolean deleteEquipmentSummary(Integer id);



}
