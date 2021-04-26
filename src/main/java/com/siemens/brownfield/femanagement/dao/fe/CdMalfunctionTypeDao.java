package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMalfunctionType;

public interface CdMalfunctionTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMalfunctionType record);

    int insertSelective(CdMalfunctionType record);

    CdMalfunctionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMalfunctionType record);

    int updateByPrimaryKey(CdMalfunctionType record);
}
