package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.AssetDao;
import com.siemens.brownfield.femanagement.dto.AssetDto;
import com.siemens.brownfield.femanagement.service.AssetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetDao assetDao;

    public AssetServiceImpl(AssetDao assetDao) {
        this.assetDao = assetDao;
    }

    @Override
    public List<AssetDto> getAssetList() {
        return assetDao.getAssetList().stream()
                .map(AssetDto::from).collect(Collectors.toList());
    }
}
