package com.siemens.brownfield.femanagement.controller;


import com.siemens.brownfield.femanagement.dto.SparePartDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/spare-part")
public class SparePartController {

    @GetMapping
    public List<SparePartDto> getSpareParts() {
        return Collections.singletonList(SparePartDto.builder()
                .id(3)
                .name("test")
                .code("code")
                .unit("个")
                .stock(100)
                .build());
    }
}
