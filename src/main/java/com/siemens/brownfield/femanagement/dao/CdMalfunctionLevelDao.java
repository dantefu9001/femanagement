package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdMalfunctionLevel;

public interface CdMalfunctionLevelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMalfunctionLevel record);

    int insertSelective(CdMalfunctionLevel record);

    CdMalfunctionLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMalfunctionLevel record);

    int updateByPrimaryKey(CdMalfunctionLevel record);
}
