package com.siemens.brownfield.femanagement.controller;


import com.siemens.brownfield.femanagement.dto.AssetDto;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.service.PlantService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/plant")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/production-line/list")
    public List<ProductionLineDto> getProductionLines() {
        return plantService.getProductionLines();
    }

    @PostMapping("/production-line/add")
    public void addProductionLine(@RequestBody ProductionLineDto dto) {
        plantService.addProductionLine(dto);
    }

    @PostMapping("/production-line/edit")
    public void updateProductionLine(@RequestBody ProductionLineDto dto) {
        plantService.updateProductionLine(dto);
    }

    @PostMapping("/production-line/delete")
    public void deleteProductionLine(@RequestBody ProductionLineDto dto) {
        plantService.deleteProductionLine(dto);
    }

    @GetMapping("/process/list")
    public List<ProcessDto> getProcesses(@RequestParam("parentId") Integer parentId) {
        return plantService.getProcessesByProductionId(parentId);
    }

    @PostMapping("/process/add")
    public void addProcess(@RequestBody ProcessDto dto) {
        plantService.addProcess(dto);
    }

    @PostMapping("/process/edit")
    public void updateProcess(@RequestBody ProcessDto dto) {
        plantService.updateProcess(dto);
    }

    @PostMapping("/process/delete")
    public void deleteProcess(@RequestBody ProcessDto dto) {
        plantService.deleteProcess(dto);
    }

    @GetMapping("/asset/list")
    public List<AssetDto> getAssets(@RequestParam("parentId") Integer parentId) {
        return plantService.getAssetsByProcessId(parentId);
    }

    @PostMapping("/asset/add")
    public void addAsset(@RequestBody AssetDto dto) {
        plantService.addAssets(dto);
    }

    @PostMapping("/asset/edit")
    public void updateAsset(@RequestBody AssetDto dto) {
        plantService.updateAssets(dto);
    }

    @PostMapping("/asset/delete")
    public void deleteAsset(@RequestBody AssetDto dto) {
        plantService.deleteAssets(dto);
    }
}
