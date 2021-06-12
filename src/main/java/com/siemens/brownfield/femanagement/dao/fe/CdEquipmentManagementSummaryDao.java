package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentManagementSummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CdEquipmentManagementSummaryDao {

    List<CdEquipmentManagementSummary> getEquipmentManagementSummary(@Param("type") String type,@Param("summary") String summary);

    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipmentManagementSummary record);

    int insertSelective(CdEquipmentManagementSummary record);

    CdEquipmentManagementSummary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipmentManagementSummary record);

    int updateByPrimaryKey(CdEquipmentManagementSummary record);
}
