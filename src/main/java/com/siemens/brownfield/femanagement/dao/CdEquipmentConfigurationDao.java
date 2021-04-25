package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdEquipmentConfiguration;

public interface CdEquipmentConfigurationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipmentConfiguration record);

    int insertSelective(CdEquipmentConfiguration record);

    CdEquipmentConfiguration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipmentConfiguration record);

    int updateByPrimaryKey(CdEquipmentConfiguration record);
}
