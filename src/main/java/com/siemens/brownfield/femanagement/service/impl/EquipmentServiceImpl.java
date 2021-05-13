package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.service.EquipmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EquipmentServiceImpl implements EquipmentService {

    private final CdEquipmentDao equipmentDao;

    public EquipmentServiceImpl(CdEquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    @Override
    public List<EquipmentDto> getEquipments(String name, String code) {
        return equipmentDao.getEquipments(name, code).stream().map(equipment -> EquipmentDto.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .code(equipment.getCode())
                .isAutoDispatch(equipment.getIsAutoDispatch())
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
        CdEquipment equipment = CdEquipment.builder()
                .id(equipmentDto.getId())
                .name(equipmentDto.getName())
                .code(equipmentDto.getCode())
                .dateOfProduction(Date.from(equipmentDto.getDateOfProduction()))
                .build();
        try {
            equipmentDao.insert(equipment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
