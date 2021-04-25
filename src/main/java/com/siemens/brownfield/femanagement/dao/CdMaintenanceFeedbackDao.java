package com.siemens.brownfield.femanagement.dao;

import com.siemens.brownfield.femanagement.entity.CdMaintenanceFeedback;

public interface CdMaintenanceFeedbackDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenanceFeedback record);

    int insertSelective(CdMaintenanceFeedback record);

    CdMaintenanceFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenanceFeedback record);

    int updateByPrimaryKey(CdMaintenanceFeedback record);
}
