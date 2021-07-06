package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import lombok.Data;

/**
 * cd_equipment_basic_file
 * @author
 */
@Data
public class CdEquipmentBasicFile implements Serializable {
    private String fileId;

    private byte[] fileContent;

    private String fileType;

    private static final long serialVersionUID = 1L;
}
