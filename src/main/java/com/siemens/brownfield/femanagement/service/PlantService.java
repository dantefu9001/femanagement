package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.AssetDto;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;

import java.util.List;

public interface PlantService {

    List<ProductionLineDto> getProductionLines();

    void deleteProductionLine(ProductionLineDto productionLineDto);

    void updateProductionLine(ProductionLineDto productionLineDto);

    void addProductionLine(ProductionLineDto productionLineDto);

    List<ProcessDto> getProcessesByProductionId(Integer productionId);

    void deleteProcess(ProcessDto processDto);

    void updateProcess(ProcessDto processDto);

    void addProcess(ProcessDto processDto);

    List<AssetDto> getAssetsByProcessId(Integer processId);

    void deleteAssets(AssetDto assetDto);

    void updateAssets(AssetDto assetDto);

    void addAssets(AssetDto assetDto);
}
