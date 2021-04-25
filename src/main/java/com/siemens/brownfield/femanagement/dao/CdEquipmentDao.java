package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdEquipment;

public interface CdEquipmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipment record);

    int insertSelective(CdEquipment record);

    CdEquipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipment record);

    int updateByPrimaryKey(CdEquipment record);
}
