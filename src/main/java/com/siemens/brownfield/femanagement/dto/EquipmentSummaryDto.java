package com.siemens.brownfield.femanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

/**
 * cd_equipment_managment_summary
 *
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentSummaryDto {
    /**
     * id
     */
    private Integer id;

    /**
     * monthly/weekly
     */
    private String type;

    /**
     * 引用人员表
     */
    private Integer person;

    /**
     * 引用group表
     */
    private Integer group;

    /**
     * 时间
     */
    private String summaryTime;

    /**
     * 小结
     */
    private String summary;

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
     * 引用企业机构表
     */
    private Integer enterprise;

}
