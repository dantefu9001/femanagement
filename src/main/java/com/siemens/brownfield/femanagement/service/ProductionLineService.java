package com.siemens.brownfield.femanagement.service;

import com.siemens.brownfield.femanagement.dto.ProductionLineDto;

import java.util.List;

public interface ProductionLineService {

    List<ProductionLineDto> getProductionLines();
}
