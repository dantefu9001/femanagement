package com.siemens.brownfield.femanagement.entity.fe;

import com.siemens.brownfield.femanagement.dto.EquipmentSummaryDto;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * cd_equipment_management_summary
 * @author
 */
@Data
public class CdEquipmentManagementSummary implements Serializable {
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
    private Date summaryTime;

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

    public static CdEquipmentManagementSummary from(EquipmentSummaryDto summaryDto) {
        CdEquipmentManagementSummary equipmentManagementSummary = new CdEquipmentManagementSummary();
        equipmentManagementSummary.setSummary(summaryDto.getSummary());
        equipmentManagementSummary.setSummaryTime(summaryDto.getSummaryTime());
        equipmentManagementSummary.setPerson(summaryDto.getPerson());
        equipmentManagementSummary.setGroup(summaryDto.getGroup());
        equipmentManagementSummary.setType(summaryDto.getType());
        equipmentManagementSummary.setCreatedTime(Date.from(Instant.now()));
        equipmentManagementSummary.setUpdatedTime(Date.from(Instant.now()));
        return equipmentManagementSummary;
    }
}
