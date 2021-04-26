package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dao.bf.PersonDao;
import com.siemens.brownfield.femanagement.entity.bf.Person;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@CrossOrigin
@RestController(value = "/equipments")
public class EquipmentController {

    private final CdEquipmentDao equipmentDao;

    private final PersonDao personDao;

    public EquipmentController(CdEquipmentDao equipmentDao, PersonDao personDao) {
        this.equipmentDao = equipmentDao;
        this.personDao = personDao;
    }

    @ApiOperation(value = "获取指定设备")
    @GetMapping("/{id}")
    public String getEquipmentById(@PathParam("id")Integer id) {
        return "success";
    }
}
