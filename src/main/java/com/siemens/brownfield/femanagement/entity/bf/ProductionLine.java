package com.siemens.brownfield.femanagement.entity.bf;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * production_line
 * @author
 */
@Data
public class ProductionLine implements Serializable {
    private Integer id;

    private Integer organizationId;

    private String productionLineNum;

    private Integer batchNumber;

    private Date creationTime;

    private String description;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}
