package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenanceConsumption;
import com.siemens.brownfield.femanagement.entity.fe.CdSparePart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CdSparePartDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdSparePart record);

    int insertSelective(CdSparePart record);

    CdSparePart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdSparePart record);

    int updateByPrimaryKey(CdSparePart record);

    List<CdSparePart> getList();

    List<CdSparePart> getConsumptionsByMaintenance(@Param("maintenanceId")Integer id);

}
