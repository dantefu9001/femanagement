package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdMalfunctionType;

public interface CdMalfunctionTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMalfunctionType record);

    int insertSelective(CdMalfunctionType record);

    CdMalfunctionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMalfunctionType record);

    int updateByPrimaryKey(CdMalfunctionType record);
}
