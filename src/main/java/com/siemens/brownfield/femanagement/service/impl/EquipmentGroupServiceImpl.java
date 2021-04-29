package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentGroupDao;
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
}
