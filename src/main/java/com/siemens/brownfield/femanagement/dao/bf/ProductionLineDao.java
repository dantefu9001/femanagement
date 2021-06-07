package com.siemens.brownfield.femanagement.dao.bf;

import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.entity.bf.ProductionLine;

import java.util.List;

public interface ProductionLineDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductionLine record);

    int insertSelective(ProductionLine record);

    ProductionLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductionLine record);

    int updateByPrimaryKey(ProductionLine record);

    List<ProductionLine> getProductionLines();
}
