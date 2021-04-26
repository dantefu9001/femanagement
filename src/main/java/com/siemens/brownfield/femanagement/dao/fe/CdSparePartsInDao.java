package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdSparePartsIn;

public interface CdSparePartsInDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdSparePartsIn record);

    int insertSelective(CdSparePartsIn record);

    CdSparePartsIn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdSparePartsIn record);

    int updateByPrimaryKey(CdSparePartsIn record);
}
