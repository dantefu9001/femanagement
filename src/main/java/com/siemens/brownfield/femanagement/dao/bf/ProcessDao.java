package com.siemens.brownfield.femanagement.dao.bf;

import com.siemens.brownfield.femanagement.entity.bf.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> getProcessList();

    void deleteProcessProcessLineRelationByProcessLineId(Integer productionLineId);

    List<Integer> getProcessListByParentId(Integer productionLineId);

    List<Process> selectByIds(List<Integer> processIds);

    void deleteProcessProductionLineRelation(@Param("parentId") Integer parentId, @Param("id") Integer id);

    void insertProcessProductionLineRelation(@Param("id") Integer id, @Param("parentId") Integer parentId);
}
