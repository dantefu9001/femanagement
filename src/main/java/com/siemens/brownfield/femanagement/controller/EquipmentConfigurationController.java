package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dto.EquipmentConfigurationDeleteDto;
import com.siemens.brownfield.femanagement.dto.EquipmentConfigurationDto;
import com.siemens.brownfield.femanagement.service.EquipmentConfigurationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/equipment-params")
public class EquipmentConfigurationController {

    private final EquipmentConfigurationService equipmentConfigurationService;

    public EquipmentConfigurationController(EquipmentConfigurationService equipmentConfigurationService) {
        this.equipmentConfigurationService = equipmentConfigurationService;
    }

    @GetMapping("list")
    public List<EquipmentConfigurationDto> getEquipmentConfigurationByEquipmentId(@RequestParam Integer equipmentId){
        return equipmentConfigurationService.getConfigurations(equipmentId);
    }

    @PostMapping
    public Boolean addEquipmentConfiguration(@RequestBody EquipmentConfigurationDto equipmentConfigurationDto) {
        return equipmentConfigurationService.addConfiguration(equipmentConfigurationDto);
    }

    @PostMapping("/delete")
    public Boolean deleteEquipmentConfiguration( @RequestBody EquipmentConfigurationDeleteDto dto) {
        return equipmentConfigurationService.deleteConfiguration(dto.getIds(), dto.getEquipmentId());
    }
}
