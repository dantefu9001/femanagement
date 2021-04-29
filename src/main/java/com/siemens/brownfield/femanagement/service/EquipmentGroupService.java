package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentGroup;

import java.util.List;

public interface EquipmentGroupService {

    List<CdEquipmentGroup> getEquipmentGroups();

}
