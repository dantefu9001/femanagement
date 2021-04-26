package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenanceStatus;

public interface CdMaintenanceStatusDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenanceStatus record);

    int insertSelective(CdMaintenanceStatus record);

    CdMaintenanceStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenanceStatus record);

    int updateByPrimaryKey(CdMaintenanceStatus record);
}
