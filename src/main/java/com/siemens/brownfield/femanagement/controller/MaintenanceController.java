package com.siemens.brownfield.femanagement.controller;

import com.alibaba.excel.EasyExcel;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("export")
    public void export(@Nullable @RequestParam("startDate") String start,
                       @Nullable @RequestParam("endDate") String end,
                       @Nullable @RequestParam("status") String status,
                       @Nullable @RequestParam("equipment") String equipment,
                       @Nullable @RequestParam("equipmentGroup") String group,
                       HttpServletResponse response) throws IOException {
        List<MaintenanceDto.MaintenanceExportData> maintenanceDtos = getMaintenanceList(start, end, status, equipment, group)
                .stream().map(MaintenanceDto.MaintenanceExportData::from).collect(Collectors.toList());

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now())) , "UTF-8")
                .replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), MaintenanceDto.MaintenanceExportData.class).sheet("维修历史").doWrite(maintenanceDtos);
    }
}
