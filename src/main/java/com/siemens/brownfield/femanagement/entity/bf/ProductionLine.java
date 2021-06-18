package com.siemens.brownfield.femanagement.entity.bf;

import java.io.Serializable;
import java.util.Date;

import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * production_line
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionLine implements Serializable {
    private Integer id;

    private Integer organizationId;

    private String productionLineNum;

    private Integer batchNumber;

    private Date creationTime;

    private String description;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public static ProductionLine from(ProductionLineDto productionLineDto) {
        return ProductionLine.builder()
                .id(productionLineDto.getId())
                .productionLineNum(productionLineDto.getName())
                .build();
    }
}
