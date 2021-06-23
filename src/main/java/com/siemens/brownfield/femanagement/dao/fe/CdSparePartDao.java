package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdSparePart;

import java.util.Arrays;
import java.util.List;

public interface CdSparePartDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CdSparePart record);

    int insertSelective(CdSparePart record);

    CdSparePart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdSparePart record);

    int updateByPrimaryKey(CdSparePart record);

    List<CdSparePart> getList();
}
