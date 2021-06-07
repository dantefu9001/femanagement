package com.siemens.brownfield.femanagement.dao.bf;

import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.entity.bf.Process;

import java.util.List;

public interface ProcessDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> getProcessList();
}
