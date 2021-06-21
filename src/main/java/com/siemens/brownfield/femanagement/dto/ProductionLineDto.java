package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.bf.ProductionLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionLineDto {
    private Integer id;
    private Integer parentId;
    private String name;

    public ProductionLineDto(Integer id){
        this.id = id;
    }

    public static ProductionLineDto from(ProductionLine productionLine) {
        return ProductionLineDto.builder()
                .id(productionLine.getId())
                .name(productionLine.getProductionLineNum())
                .build();
    }

}
