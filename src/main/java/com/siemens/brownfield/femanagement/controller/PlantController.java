package com.siemens.brownfield.femanagement.controller;


import com.siemens.brownfield.femanagement.dto.AssetDto;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/plant")
public class PlantController {

    @GetMapping("/production-line/list")
    public List<ProductionLineDto> getProductionLines(){
        return Collections.singletonList(ProductionLineDto.builder().id(1).name("test1").build());
    }

    @PostMapping("/production-line/add")
    public void addProductionLine(ProductionLineDto dto) {

    }

    @PostMapping("/production-line/update")
    public void updateProductionLine(ProductionLineDto dto) {

    }

    @PostMapping("/production-line/delete")
    public void deleteProductionLine(ProductionLineDto dto) {

    }

    @GetMapping("/process/list")
    public List<ProcessDto> getProcesses(){
        return Collections.singletonList(ProcessDto.builder().id(2).name("hello").build());
    }

    @PostMapping("/process/add")
    public void addProcess(ProcessDto dto) {

    }

    @PostMapping("/process/update")
    public void updateProcess(ProcessDto dto) {

    }

    @PostMapping("/process/delete")
    public void deleteProcess(ProcessDto dto) {

    }

    @GetMapping("/asset/list")
    public List<AssetDto> getAssets(){
        return Collections.singletonList(AssetDto.builder().id(3).name("nihao").build());
    }

    @PostMapping("/asset/add")
    public void addAsset(AssetDto dto) {

    }

    @PostMapping("/asset/update")
    public void updateAsset(AssetDto dto) {

    }

    @PostMapping("/asset/delete")
    public void deleteAsset(AssetDto dto) {

    }
}
