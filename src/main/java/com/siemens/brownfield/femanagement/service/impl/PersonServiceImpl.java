package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.PersonDao;
import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<PersonDto> getPersonnel() {
        return personDao.selectPersonnel().stream().map(PersonDto::from).collect(Collectors.toList());
    }

    @Override
    public PersonDto getPersonnelById(Integer id) {
        return PersonDto.from(personDao.selectByPrimaryKey(id));
    }
}
