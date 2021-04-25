package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdSparePart;

public interface CdSparePartDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdSparePart record);

    int insertSelective(CdSparePart record);

    CdSparePart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdSparePart record);

    int updateByPrimaryKey(CdSparePart record);
}
