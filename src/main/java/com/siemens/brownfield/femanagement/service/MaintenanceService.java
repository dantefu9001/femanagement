package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
import com.siemens.brownfield.femanagement.dto.MaintenanceResDto;

import java.util.List;

public interface MaintenanceService {
    List<MaintenanceDto> getMaintenanceList(String start, String end, String equipment, String group);

    void add(MaintenanceDto dto);

    void delete(MaintenanceDto dto);
}