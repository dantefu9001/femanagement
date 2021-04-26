package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;

public interface CdMaintenanceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenance record);

    int insertSelective(CdMaintenance record);

    CdMaintenance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenance record);

    int updateByPrimaryKey(CdMaintenance record);
}
