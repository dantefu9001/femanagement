package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.EquipmentSummaryDto;

import java.util.List;

public interface EquipmentsSummaryService {

    List<EquipmentSummaryDto> getSummaryList(String type, String description);

    Boolean addEquipmentSummary(EquipmentSummaryDto equipmentSummaryDto);

    Boolean updateEquipmentSummary(EquipmentSummaryDto equipmentSummaryDto);

    Boolean deleteEquipmentSummary(List<Integer> ids);



}
