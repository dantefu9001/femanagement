package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdSparePartsOut;

public interface CdSparePartsOutDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdSparePartsOut record);

    int insertSelective(CdSparePartsOut record);

    CdSparePartsOut selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdSparePartsOut record);

    int updateByPrimaryKey(CdSparePartsOut record);
}
