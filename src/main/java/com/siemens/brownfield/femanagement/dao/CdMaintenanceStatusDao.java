package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdMaintenanceStatus;

public interface CdMaintenanceStatusDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenanceStatus record);

    int insertSelective(CdMaintenanceStatus record);

    CdMaintenanceStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenanceStatus record);

    int updateByPrimaryKey(CdMaintenanceStatus record);
}
