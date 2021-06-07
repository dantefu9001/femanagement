package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.common.CommonResult;
import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.service.PersonService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/personnel")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/list")
    public List<PersonDto> getPersonnel(){
        return personService.getPersonnel();
    }
}
