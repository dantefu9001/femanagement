package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.EquipmentDto;

import java.util.List;

public interface EquipmentService {

    List<EquipmentDto> getEquipments();

    EquipmentDto getEquipmentById(Integer id);

    Boolean addEquipment(EquipmentDto equipmentDto);

    EquipmentDto updateEquipment(EquipmentDto equipmentDto);

    Boolean deleteEquipment(Integer id);



}
