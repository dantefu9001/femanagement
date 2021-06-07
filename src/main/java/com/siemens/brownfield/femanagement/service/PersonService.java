package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.entity.bf.Person;

import java.util.List;

public interface PersonService {
    List<PersonDto> getPersonnel();

    PersonDto getPersonnelById(Integer id);
}
