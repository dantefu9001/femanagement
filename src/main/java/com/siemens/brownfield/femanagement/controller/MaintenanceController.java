package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
import com.siemens.brownfield.femanagement.service.MaintenanceService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
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
        if (Strings.isEmpty(status)) {
            return maintenanceService.getMaintenanceList(start, end, Collections.emptyList(), equipment, group);
        }
        return maintenanceService.getMaintenanceList(start, end, Arrays.asList(status.split(",")), equipment, group);
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
        maintenanceService.updateStatus(dto);
    }

    @PostMapping("/submitter/validate")
    public void validateMaintenance(@RequestBody MaintenanceDto dto) {
        maintenanceService.validateBySubmitter(dto);
    }

    @PostMapping("/auditor/dispatch")
    public void dispatchMaintenance(@RequestBody MaintenanceDto dto){
        maintenanceService.dispatch(dto);
    }

    @PostMapping("/auditor/confirm")
    public void confirmMaintenanceDispatch(@RequestBody MaintenanceDto dto){
        maintenanceService.confirmDispatch(dto);
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
    public void approveMaintenanceValidation(@RequestBody MaintenanceDto dto) {
        maintenanceService.approveValidation(dto.getIds());
    }

    @PostMapping("/maintainer")
    public void updateMaintenance(@RequestBody MaintenanceDto dto) {
        maintenanceService.maintain(dto);
    }
}
