package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMalfunctionLevel;

public interface CdMalfunctionLevelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMalfunctionLevel record);

    int insertSelective(CdMalfunctionLevel record);

    CdMalfunctionLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMalfunctionLevel record);

    int updateByPrimaryKey(CdMalfunctionLevel record);
}
