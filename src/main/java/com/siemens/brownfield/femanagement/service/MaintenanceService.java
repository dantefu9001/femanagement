package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.MaintenanceDto;

import java.util.List;

public interface MaintenanceService {
    List<MaintenanceDto> getMaintenanceList(String start, String end,String status, String equipment, String group);

    void add(MaintenanceDto dto);

    void delete(List<Integer> ids);

    void audit(List<Integer> ids);
}
