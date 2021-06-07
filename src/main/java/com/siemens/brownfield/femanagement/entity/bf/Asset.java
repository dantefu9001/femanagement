package com.siemens.brownfield.femanagement.entity.bf;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * asset
 * @author
 */
@Data
public class Asset implements Serializable {
    private Integer id;

    private String assetNum;

    private String assetName;

    private String physicalLocation;

    private String vendor;

    private String manufacturer;

    private String groupLeader;

    private Date availableTime;

    private Boolean available;

    private Integer organizationId;

    private String description;

    private Date creationTime;

    private String creator;

    private String basicDataVersion;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}
