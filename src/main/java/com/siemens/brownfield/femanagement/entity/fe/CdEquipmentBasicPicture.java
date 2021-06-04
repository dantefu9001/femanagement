package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import lombok.Data;

/**
 * cd_equipment_basic_picture
 * @author
 */
@Data
public class CdEquipmentBasicPicture implements Serializable {

    private byte[] fileContent;

    private String fileId;

    private static final long serialVersionUID = 1L;
}
