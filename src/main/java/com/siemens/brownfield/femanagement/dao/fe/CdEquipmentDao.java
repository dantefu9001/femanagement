package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CdEquipmentDao {

    List<CdEquipment> getEquipments(@Param("name") String name,
                                    @Param("responsible") List<Integer> responsible,
                                    @Param("productionLines") List<Integer> productionLine,
                                    @Param("groupId") Integer groupId);

    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipment record);

    int insertSelective(CdEquipment record);

    CdEquipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipment record);

    int updateByPrimaryKey(CdEquipment record);
}
