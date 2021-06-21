package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
import com.siemens.brownfield.femanagement.dto.MaintenanceResDto;
import com.siemens.brownfield.femanagement.service.MaintenanceService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/submitter")
    public List<MaintenanceDto> getMaintenanceList(@Nullable @RequestParam("submitStart") String start,
                                                      @Nullable @RequestParam("submitEnd") String end,
                                                      @Nullable @RequestParam("equipment") String equipment,
                                                      @Nullable @RequestParam("group") String group) {
        return maintenanceService.getMaintenanceList(start, end, equipment, group);
    }

    @PostMapping("/submitter")
    public void addMaintenanceSheet(@RequestBody MaintenanceDto dto) {
        maintenanceService.add(dto);
    }

    @PostMapping("/submitter/delete")
    public void deleteMaintenanceSheet(@RequestBody MaintenanceDto dto) {
        maintenanceService.delete(dto);
    }
}
