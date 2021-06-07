package com.siemens.brownfield.femanagement.controller;


import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.service.ProductionLineService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/production-line")
public class ProductionLineController {

    private final ProductionLineService productionLineService;

    public ProductionLineController(ProductionLineService productionLineService) {
        this.productionLineService = productionLineService;
    }

    @GetMapping("/list")
    public List<ProductionLineDto> getProductionLines(){
        return productionLineService.getProductionLines();
    }
}
