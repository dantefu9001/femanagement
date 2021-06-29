package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenanceConsumption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CdMaintenanceConsumptionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenanceConsumption record);

    int insertSelective(CdMaintenanceConsumption record);

    CdMaintenanceConsumption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenanceConsumption record);

    int updateByPrimaryKey(CdMaintenanceConsumption record);

}
