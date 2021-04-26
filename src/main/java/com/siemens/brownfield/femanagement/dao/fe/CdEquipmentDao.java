package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;

public interface CdEquipmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipment record);

    int insertSelective(CdEquipment record);

    CdEquipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipment record);

    int updateByPrimaryKey(CdEquipment record);
}
