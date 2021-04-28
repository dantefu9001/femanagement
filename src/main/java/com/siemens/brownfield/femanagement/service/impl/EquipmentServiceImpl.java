package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.service.EquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final CdEquipmentDao equipmentDao;

    public EquipmentServiceImpl(CdEquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    @Override
    public List<EquipmentDto> getEquipments() {
        return equipmentDao.getEquipments().stream().map(equipment -> EquipmentDto.builder()
                .id(equipment.getId())
                .build()).collect(Collectors.toList());
    }

    @Override
    public EquipmentDto getEquipmentById(Integer id) {
        CdEquipment equipment = equipmentDao.selectByPrimaryKey(id);
        Assert.notNull(equipment, "设备不存在");
        return EquipmentDto.builder()
                .id(equipment.getId())
                .build();
    }

    @Override
    public Boolean addEquipment(EquipmentDto equipmentDto) {
        return null;
    }

    @Override
    public EquipmentDto updateEquipment(EquipmentDto equipmentDto) {
        return null;
    }

    @Override
    public Boolean deleteEquipment(Integer id) {
        return null;
    }
}
