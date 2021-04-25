package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdSparePartsWarehouse;

public interface CdSparePartsWarehouseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdSparePartsWarehouse record);

    int insertSelective(CdSparePartsWarehouse record);

    CdSparePartsWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdSparePartsWarehouse record);

    int updateByPrimaryKey(CdSparePartsWarehouse record);
}
