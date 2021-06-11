package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.common.CommonResult;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.service.EquipmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
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
    public List<EquipmentDto> getEquipments(@Nullable @RequestParam("name") String name,
                                            @Nullable @RequestParam("responsible") String responsible,
                                            @Nullable @RequestParam("workshop") String workshop) {
        return equipmentService.getEquipments(name, responsible, workshop);
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

    @ApiOperation(value = "删除指定id的设备")
    @DeleteMapping("/{id}")
    public CommonResult<Boolean> removeEquipmentById(@PathVariable("id") Integer id) {
        Boolean success = equipmentService.deleteEquipment(id);
        return CommonResult.<Boolean>builder()
                .data(success)
                .build();
    }

    @PostMapping("/update")
    public CommonResult<Boolean> updateEquipment(@RequestBody EquipmentDto equipmentDto) {
        return CommonResult.<Boolean>builder().data(equipmentService.updateEquipment(equipmentDto)).build();
    }

    @PostMapping(value = "/upload-pic")
    public CommonResult<String> uploadPicture(@RequestParam MultipartFile file) {
        return CommonResult.<String>builder().data(equipmentService.savePictureAsBlob(file)).build();
    }

    @GetMapping(value = "/pic/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPicture(@PathVariable String id){
        return equipmentService.getFileByBytes(id);
    }
}
