package com.siemens.brownfield.femanagement.dao.bf;

import com.siemens.brownfield.femanagement.entity.bf.Asset;

import java.util.List;

public interface AssetDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);

    List<Asset> getAssetList();
}
