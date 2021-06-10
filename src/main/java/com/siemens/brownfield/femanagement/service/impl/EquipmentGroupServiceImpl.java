package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentGroupDao;
import com.siemens.brownfield.femanagement.dto.EquipmentGroupDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentGroup;
import com.siemens.brownfield.femanagement.service.EquipmentGroupService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class EquipmentGroupServiceImpl implements EquipmentGroupService {


    private final CdEquipmentGroupDao equipmentGroupDao;

    public EquipmentGroupServiceImpl(CdEquipmentGroupDao equipmentGroupDao) {
        this.equipmentGroupDao = equipmentGroupDao;
    }

    @Override
    public List<CdEquipmentGroup> getEquipmentGroups() {
        return equipmentGroupDao.getEquipmentGroups();
    }

    @Override
    public Boolean addEquipmentGroup(EquipmentGroupDto equipmentGroupDto) {
        CdEquipmentGroup equipmentGroup = CdEquipmentGroup.from(equipmentGroupDto);
        equipmentGroup.setIsDelete("0");
        return equipmentGroupDao.insertSelective(equipmentGroup) == 1;
    }

    @Override
    public Boolean deleteGroup(EquipmentGroupDto equipmentGroupDto) {
        CdEquipmentGroup group = CdEquipmentGroup.from(equipmentGroupDto);
        group.setIsDelete("1");
        return equipmentGroupDao.updateByPrimaryKeySelective(group) == 1;
    }

    @Override
    public Boolean updateGroup(EquipmentGroupDto equipmentGroupDto) {
        CdEquipmentGroup group = CdEquipmentGroup.from(equipmentGroupDto);
        return equipmentGroupDao.updateByPrimaryKeySelective(group) == 1;
    }
}
