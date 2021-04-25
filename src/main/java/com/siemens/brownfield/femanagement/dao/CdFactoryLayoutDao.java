package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdFactoryLayout;

public interface CdFactoryLayoutDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdFactoryLayout record);

    int insertSelective(CdFactoryLayout record);

    CdFactoryLayout selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdFactoryLayout record);

    int updateByPrimaryKey(CdFactoryLayout record);
}
