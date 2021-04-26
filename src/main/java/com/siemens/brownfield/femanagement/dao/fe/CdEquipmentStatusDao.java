package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentStatus;

public interface CdEquipmentStatusDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipmentStatus record);

    int insertSelective(CdEquipmentStatus record);

    CdEquipmentStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipmentStatus record);

    int updateByPrimaryKey(CdEquipmentStatus record);
}
