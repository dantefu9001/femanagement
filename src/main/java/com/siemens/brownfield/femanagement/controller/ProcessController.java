package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.service.ProcessService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/process")
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @GetMapping("/list")
    public List<ProcessDto> getProcessList(){
        return processService.getProcessList();
    }
}
