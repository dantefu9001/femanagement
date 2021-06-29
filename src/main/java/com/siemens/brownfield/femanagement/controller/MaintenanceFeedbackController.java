package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dao.fe.CdMaintenanceFeedbackDao;
import com.siemens.brownfield.femanagement.dto.MaintenanceFeedbackDto;
import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.service.PersonService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/rating")
public class MaintenanceFeedbackController {

    private final CdMaintenanceFeedbackDao cdMaintenanceFeedbackDao;

    public MaintenanceFeedbackController(CdMaintenanceFeedbackDao cdMaintenanceFeedbackDao) {
        this.cdMaintenanceFeedbackDao = cdMaintenanceFeedbackDao;
    }

    @GetMapping()
    public MaintenanceFeedbackDto getFeedback(@RequestParam("id") Integer id){
        return MaintenanceFeedbackDto.from(cdMaintenanceFeedbackDao.selectByMaintenance(id));
    }
}
