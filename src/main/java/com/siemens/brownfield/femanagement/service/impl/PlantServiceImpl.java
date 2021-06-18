package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.AssetDao;
import com.siemens.brownfield.femanagement.dao.bf.ProcessDao;
import com.siemens.brownfield.femanagement.dao.bf.ProductionLineDao;
import com.siemens.brownfield.femanagement.dto.AssetDto;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.entity.bf.Asset;
import com.siemens.brownfield.femanagement.entity.bf.Process;
import com.siemens.brownfield.femanagement.entity.bf.ProductionLine;
import com.siemens.brownfield.femanagement.service.PlantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlantServiceImpl implements PlantService {

    private final ProductionLineDao productionLineDao;

    private final ProcessDao processDao;

    private final AssetDao assetDao;

    public PlantServiceImpl(ProductionLineDao productionLineDao, ProcessDao processDao, AssetDao assetDao) {
        this.productionLineDao = productionLineDao;
        this.processDao = processDao;
        this.assetDao = assetDao;
    }

    @Override
    public List<ProductionLineDto> getProductionLines() {
        return productionLineDao.getProductionLines().stream()
                .map(ProductionLineDto::from).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProductionLine(ProductionLineDto productionLineDto) {
        Integer productionLineId = productionLineDto.getId();
        productionLineDao.deleteProduction(productionLineId);
        processDao.deleteProcessProcessLineRelationByProcessLineId(productionLineId);
        processDao.getProcessListByParentId(productionLineId).forEach(assetDao::deleteAssetProcessRelationByProcessId);
    }

    @Override
    public void updateProductionLine(ProductionLineDto productionLineDto) {
        productionLineDao.updateByPrimaryKeySelective(ProductionLine.from(productionLineDto));
    }

    @Override
    public void addProductionLine(ProductionLineDto productionLineDto) {
        productionLineDao.insertSelective(ProductionLine.from(productionLineDto));
    }

    @Override
    public List<ProcessDto> getProcessesByProductionId(Integer productionId) {
        List<Integer> processIds = processDao.getProcessListByParentId(productionId);
        if(CollectionUtils.isEmpty(processIds)){
            return Collections.emptyList();
        }
        return processDao.selectByIds(processIds).stream().map(ProcessDto::from).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProcess(ProcessDto processDto) {
        processDao.deleteProcessProductionLineRelation(processDto.getParentId(), processDto.getId());
        assetDao.deleteAssetProcessRelationByProcessId(processDto.getId());
    }

    @Override
    public void updateProcess(ProcessDto processDto) {
        processDao.updateByPrimaryKeySelective(Process.from(processDto));
    }

    @Override
    public void addProcess(ProcessDto processDto) {
        processDao.insertProcessProductionLineRelation(processDto.getId(), processDto.getParentId());
    }

    @Override
    public List<AssetDto> getAssetsByProcessId(Integer processId) {
        List<Integer> ids = assetDao.getAssetListByParentId(processId);
        if(CollectionUtils.isEmpty(ids)){
            return Collections.emptyList();
        }
        return assetDao.selectByIds(ids).stream().map(AssetDto::from).collect(Collectors.toList());
    }

    @Override
    public void deleteAssets(AssetDto assetDto) {
        assetDao.deleteAssetProcessRelation(assetDto.getId(), assetDto.getParentId());
    }

    @Override
    public void updateAssets(AssetDto assetDto) {
        assetDao.updateByPrimaryKeySelective(Asset.from(assetDto));
    }

    @Override
    public void addAssets(AssetDto assetDto) {
        assetDao.insertAssetProcessRelation(assetDto.getId(), assetDto.getParentId());
    }
}
