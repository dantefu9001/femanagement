package com.siemens.brownfield.femanagement.dao.bf;

import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.entity.bf.Person;

import java.util.List;

public interface PersonDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> selectPersonnel();

    List<Person> selectByName(String responsible);
}
