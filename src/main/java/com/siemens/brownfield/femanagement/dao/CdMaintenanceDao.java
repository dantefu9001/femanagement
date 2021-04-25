package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdMaintenance;

public interface CdMaintenanceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenance record);

    int insertSelective(CdMaintenance record);

    CdMaintenance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenance record);

    int updateByPrimaryKey(CdMaintenance record);
}
