package com.siemens.brownfield.femanagement.controller;


import com.siemens.brownfield.femanagement.dto.SparePartDto;
import com.siemens.brownfield.femanagement.service.SparePartService;
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

    private final SparePartService sparePartService;

    public SparePartController(SparePartService sparePartService) {
        this.sparePartService = sparePartService;
    }

    @GetMapping
    public List<SparePartDto> getSpareParts() {
        return sparePartService.getSpareParts();
    }
}
