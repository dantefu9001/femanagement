package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentGroup;
import com.siemens.brownfield.femanagement.service.EquipmentGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/equipment-groups")
public class EquipmentGroupController {

    private final EquipmentGroupService equipmentGroupService;

    public EquipmentGroupController(EquipmentGroupService equipmentGroupService) {
        this.equipmentGroupService = equipmentGroupService;
    }

    @ApiOperation(value = "获取所有设备列表")
    @GetMapping()
    public List<CdEquipmentGroup> getEquipments() {
        return equipmentGroupService.getEquipmentGroups();
    }

}
