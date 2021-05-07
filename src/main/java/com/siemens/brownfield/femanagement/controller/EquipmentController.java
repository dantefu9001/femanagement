package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.common.CommonResult;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.service.EquipmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @ApiOperation(value = "获取所有设备列表")
    @GetMapping()
    public List<EquipmentDto> getEquipments(@Nullable @RequestParam("equipmentName") String name,
                                            @Nullable @RequestParam("equipmentCode") String code) {
        return equipmentService.getEquipments(name, code);
    }

    @ApiOperation(value = "获取指定设备")
    @GetMapping("/{id}")
    public EquipmentDto getEquipmentById(@PathVariable("id") Integer id) {
        return equipmentService.getEquipmentById(id);
    }

    @PostMapping()
    public CommonResult<Boolean> addEquipment(@RequestBody EquipmentDto equipmentDto) {
        Boolean success = equipmentService.addEquipment(equipmentDto);
        return CommonResult.<Boolean>builder()
                .data(success)
                .build();
    }
}
