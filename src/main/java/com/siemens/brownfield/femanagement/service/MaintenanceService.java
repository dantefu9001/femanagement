package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.MaintenanceDto;

import java.util.List;

public interface MaintenanceService {
    List<MaintenanceDto> getMaintenanceList(String start, String end,List<String> status, String equipment, String group);

    void add(MaintenanceDto dto);

    void delete(List<Integer> ids);

    void audit(List<Integer> ids);

    void maintain(MaintenanceDto dto);

    void rate(MaintenanceDto dto);

    void updateStatus(MaintenanceDto dto);

    void validateBySubmitter(MaintenanceDto dto);

    void approveValidation(List<Integer> ids);

    void dispatch(MaintenanceDto dto);

    void confirmDispatch(MaintenanceDto dto);
}
