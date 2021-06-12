package com.siemens.brownfield.femanagement.entity.fe;

import com.siemens.brownfield.femanagement.dto.EquipmentSummaryDto;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;

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
        equipmentManagementSummary.setId(summaryDto.getId());
        equipmentManagementSummary.setSummary(summaryDto.getSummary());
        equipmentManagementSummary.setSummaryTime(Date.from(Instant.now()));
        equipmentManagementSummary.setPerson(summaryDto.getPerson());
        equipmentManagementSummary.setGroup(summaryDto.getGroup());
        equipmentManagementSummary.setType(summaryDto.getType());
        equipmentManagementSummary.setIsDelete("0");
        equipmentManagementSummary.setCreatedTime(Date.from(Instant.now()));
        equipmentManagementSummary.setUpdatedTime(Date.from(Instant.now()));
        return equipmentManagementSummary;
    }

    public enum EquipmentManagementSummary{
        weekly("周总结"),
        monthly("月总结");

        private String value;

        EquipmentManagementSummary(String value){
            this.value = value;
        }

        public static String getValueByType(String type){
            if (Strings.isEmpty(type)) {
                return Strings.EMPTY;
            }
            return EquipmentManagementSummary.valueOf(type).value;
        }
    }
}
