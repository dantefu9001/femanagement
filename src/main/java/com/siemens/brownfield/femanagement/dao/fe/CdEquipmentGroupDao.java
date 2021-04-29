package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentGroup;

import java.util.List;

public interface CdEquipmentGroupDao {

    List<CdEquipmentGroup> getEquipmentGroups();

    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipmentGroup record);

    int insertSelective(CdEquipmentGroup record);

    CdEquipmentGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipmentGroup record);

    int updateByPrimaryKey(CdEquipmentGroup record);
}
