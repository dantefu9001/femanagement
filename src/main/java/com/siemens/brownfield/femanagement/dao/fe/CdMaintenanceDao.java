package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CdMaintenanceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMaintenance record);

    int insertSelective(CdMaintenance record);

    CdMaintenance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMaintenance record);

    int updateByPrimaryKey(CdMaintenance record);

    List<CdMaintenance> getList(@Param("equipment") String equipment, @Param("group") String group,
                                @Param("status") String status,
                                @Param("startDate") String start, @Param("endDate") String end);

    void batchSoftDelete(List<Integer> ids);

    void audit(List<Integer> ids);

}
