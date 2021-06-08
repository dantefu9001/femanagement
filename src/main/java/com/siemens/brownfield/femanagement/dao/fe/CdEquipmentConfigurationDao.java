package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.dto.EquipmentConfigurationDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentConfiguration;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CdEquipmentConfigurationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdEquipmentConfiguration record);

    int insertSelective(CdEquipmentConfiguration record);

    CdEquipmentConfiguration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdEquipmentConfiguration record);

    int updateByPrimaryKey(CdEquipmentConfiguration record);

    List<CdEquipmentConfiguration> getEquipmentConfigurationList(Integer equipmentId);

    int softDeleteConfigurations(@Param("ids") List<Integer> ids,@Param("equipmentId") Integer equipmentId);
}
