package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
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
    public List<MaintenanceDto> getMaintenanceList(@Nullable @RequestParam("startDate") String start,
                                                   @Nullable @RequestParam("endDate") String end,
                                                   @Nullable @RequestParam("status") String status,
                                                   @Nullable @RequestParam("equipment") String equipment,
                                                   @Nullable @RequestParam("equipmentGroup") String group) {
        return maintenanceService.getMaintenanceList(start, end, status, equipment, group);
    }

    @PostMapping("/submitter")
    public void addMaintenanceSheet(@RequestBody MaintenanceDto dto) {
        maintenanceService.add(dto);
    }

    @PostMapping("/submitter/delete")
    public void deleteMaintenanceSheet(@RequestBody MaintenanceDto dto) {
        maintenanceService.delete(dto.getIds());
    }

    @PostMapping("/submitter/rate")
    public void rateMaintenance(@RequestBody MaintenanceDto dto) {
        maintenanceService.rate(dto);
    }

    @PostMapping("/submitter/confirm")
    public void confirmMaintenance(@RequestBody MaintenanceDto dto) {
        maintenanceService.confirm(dto);
    }

    @PostMapping("/submitter/validate")
    public void validateMaintenance(@RequestBody MaintenanceDto dto){
        maintenanceService.validateBySubmitter(dto);
    }

    @PostMapping("/auditor/deprecate")
    public void deprecateMaintenanceSheet(@RequestBody MaintenanceDto dto) {
        maintenanceService.delete(dto.getIds());
    }

    @PostMapping("/auditor/audit")
    public void audiMaintenanceSheet(@RequestBody MaintenanceDto dto) {
        maintenanceService.audit(dto.getIds());
    }

    @PostMapping("/auditor/approve-validation")
    public void approveMaintenanceValidation(@RequestBody MaintenanceDto dto){
        maintenanceService.approveValidation(dto.getIds());
    }

    @PostMapping("/maintainer")
    public void updateMaintenance(@RequestBody MaintenanceDto dto) {
        maintenanceService.maintain(dto);
    }
}
