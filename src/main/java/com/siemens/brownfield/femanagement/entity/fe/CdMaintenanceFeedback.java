package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cd_maintenance_feedback
 * @author
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CdMaintenanceFeedback implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 维修单号
     */
    private Integer maintenance;

    /**
     * 响应性
     */
    private String response;

    /**
     * 维修质量
     */
    private String quality;

    /**
     * 现场5S
     */
    private String onsiteManagement;

    /**
     * 总体评价
     */
    private String overall;

    /**
     * 补充说明
     */
    private String description;

    /**
     * 评价人
     */
    private String provider;

    /**
     * 是否匿名提交
     */
    private String isAnonymous;

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
