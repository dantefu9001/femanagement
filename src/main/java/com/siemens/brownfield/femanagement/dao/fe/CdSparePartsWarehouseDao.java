package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdSparePartsWarehouse;

public interface CdSparePartsWarehouseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdSparePartsWarehouse record);

    int insertSelective(CdSparePartsWarehouse record);

    CdSparePartsWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdSparePartsWarehouse record);

    int updateByPrimaryKey(CdSparePartsWarehouse record);
}
