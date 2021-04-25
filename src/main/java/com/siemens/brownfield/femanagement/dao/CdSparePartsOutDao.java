package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdSparePartsOut;

public interface CdSparePartsOutDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdSparePartsOut record);

    int insertSelective(CdSparePartsOut record);

    CdSparePartsOut selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdSparePartsOut record);

    int updateByPrimaryKey(CdSparePartsOut record);
}
