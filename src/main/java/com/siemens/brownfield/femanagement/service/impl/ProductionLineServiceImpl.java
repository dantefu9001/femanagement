package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.ProductionLineDao;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.service.ProductionLineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductionLineServiceImpl implements ProductionLineService {

    private final ProductionLineDao productionLineDao;

    public ProductionLineServiceImpl(ProductionLineDao productionLineDao) {
        this.productionLineDao = productionLineDao;
    }

    @Override
    public List<ProductionLineDto> getProductionLines() {
        return productionLineDao.getProductionLines().stream()
                .map(ProductionLineDto::from)
                .collect(Collectors.toList());
    }
}
