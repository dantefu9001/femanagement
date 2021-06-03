package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EquipmentService {

    List<EquipmentDto> getEquipments(String name, String code);

    EquipmentDto getEquipmentById(Integer id);

    Boolean addEquipment(EquipmentDto equipmentDto);

    Boolean updateEquipment(EquipmentDto equipmentDto);

    Boolean deleteEquipment(Integer id);

    String savePictureAsBlob(MultipartFile file);

}
