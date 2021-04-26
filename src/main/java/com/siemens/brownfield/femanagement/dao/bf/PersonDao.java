package com.siemens.brownfield.femanagement.dao.bf;

import com.siemens.brownfield.femanagement.entity.bf.Person;

public interface PersonDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}
