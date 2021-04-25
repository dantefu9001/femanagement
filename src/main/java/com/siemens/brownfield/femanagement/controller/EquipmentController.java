package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dao.CdEquipmentDao;
import com.siemens.brownfield.femanagement.entity.CdEquipment;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin
public class EquipmentController {

    private final CdEquipmentDao equipmentDao;

    public EquipmentController(CdEquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    @ApiOperation(value = "获取指定设备")
    @GetMapping("equipment/{id}")
    public CdEquipment firstController(@PathParam("id")Integer id) {
        return equipmentDao.selectByPrimaryKey(id);
    }
}
