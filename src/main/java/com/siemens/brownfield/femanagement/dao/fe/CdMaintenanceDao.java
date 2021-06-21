package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;

import java.util.List;

public interface CdMaintenanceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenance record);

    int insertSelective(CdMaintenance record);

    CdMaintenance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenance record);

    int updateByPrimaryKey(CdMaintenance record);

    List<CdMaintenance> getList(String equipment, String group, String start, String end);
}
