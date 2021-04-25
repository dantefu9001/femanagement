package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdEquipmentGroup;

public interface CdEquipmentGroupDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipmentGroup record);

    int insertSelective(CdEquipmentGroup record);

    CdEquipmentGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipmentGroup record);

    int updateByPrimaryKey(CdEquipmentGroup record);
}
