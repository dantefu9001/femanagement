package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.EquipmentGroupDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentGroup;

import java.util.List;

public interface EquipmentGroupService {

    List<CdEquipmentGroup> getEquipmentGroups();

    Boolean addEquipmentGroup(EquipmentGroupDto equipmentGroupDto);

    Boolean deleteGroup(EquipmentGroupDto equipmentGroupDto);

    Boolean updateGroup(EquipmentGroupDto equipmentGroupDto);
}
