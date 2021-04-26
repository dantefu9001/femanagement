package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cd_equipment_group
 * @author
 */
@Data
public class CdMaintenanceFeedback implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 软删除标识符
     */
    private String isDelete;

    /**
     * 引用机构表
     */
    private Integer enterprise;

    private static final long serialVersionUID = 1L;
}
