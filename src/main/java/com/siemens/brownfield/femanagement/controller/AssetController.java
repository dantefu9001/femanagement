package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dto.AssetDto;
import com.siemens.brownfield.femanagement.service.AssetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/asset")
public class AssetController {

    private final AssetService assetService;


    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/list")
    public List<AssetDto> getAssetList(){
        return assetService.getAssetList();
    }
}
