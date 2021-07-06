package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EquipmentService {

    List<EquipmentDto> getEquipments(String name, String responsible, String workshop, Integer group);

    EquipmentDto getEquipmentById(Integer id);

    Boolean addEquipment(EquipmentDto equipmentDto);

    Boolean updateEquipment(EquipmentDto equipmentDto);

    Boolean deleteEquipment(Integer id);

    String savePictureAsBlob(MultipartFile file) throws IOException;

    String saveFileAsBlob(MultipartFile file) throws IOException;

    byte[] getPictureById(String id);

    byte[] getFileById(String id);

    List<EquipmentDto> getEquipmentsByProcessId(Integer processId);
}
