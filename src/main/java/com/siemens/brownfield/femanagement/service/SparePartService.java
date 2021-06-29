package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.SparePartDto;

import java.util.List;

public interface SparePartService {

    List<SparePartDto> getSpareParts();

    List<SparePartDto> getSpareParts(Integer maintenanceId);
}
