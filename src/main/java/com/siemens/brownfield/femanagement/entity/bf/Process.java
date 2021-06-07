package com.siemens.brownfield.femanagement.entity.bf;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * process
 * @author
 */
@Data
public class Process implements Serializable {
    private Integer id;

    private String processNum;

    private String processName;

    private String processCode;

    private String processType;

    private String groupLeader;

    private String readyTime;

    private Double maxWipQuantity;

    private String description;

    private Integer organizationId;

    private String creator;

    private Date creationTime;

    private Object extras;

    private String basicDataVersion;

    private Boolean deleted;

    /**
     * 小时率，供NCC使用
     */
    private Double hourlyRate;

    private static final long serialVersionUID = 1L;
}
