package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cd_maintenance_consumption
 * @author
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CdMaintenanceConsumption implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 引用维修单
     */
    private Integer maintenance;

    /**
     * 引用备件
     */
    private Integer sparePart;

    /**
     * 消耗数量
     */
    private Integer number;

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
     * 软删标识符
     */
    private String isDelete;

    /**
     * 引用机构表
     */
    private Integer enterprise;

    private static final long serialVersionUID = 1L;
}
