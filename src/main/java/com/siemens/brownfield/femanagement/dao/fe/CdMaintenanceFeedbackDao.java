package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenanceFeedback;
import org.apache.ibatis.annotations.Param;

public interface CdMaintenanceFeedbackDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenanceFeedback record);

    int insertSelective(CdMaintenanceFeedback record);

    CdMaintenanceFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenanceFeedback record);

    int updateByPrimaryKey(CdMaintenanceFeedback record);

    CdMaintenanceFeedback selectByMaintenance(@Param("maintenanceId") Integer id);
}
