package com.siemens.brownfield.femanagement.entity.fe;

import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
import com.siemens.brownfield.femanagement.dto.MaintenanceResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * cd_maintenance
 *
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CdMaintenance implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 引用设备详情表
     */
    private Integer equipment;

    /**
     * 编号
     */
    private String code;

    /**
     * 状态
     */
    private String status;

    /**
     * 引用工厂布局
     */
    private Integer workshop;

    /**
     * 引用工厂布局
     */
    private Integer area;

    /**
     * 引用工厂布局
     */
    private Integer process;

    /**
     * 引用人员
     */
    private Integer submitter;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 故障描述
     */
    private String malfunctionDesc;

    /**
     * 图片url
     */
    private String malfunctionPhotos;

    /**
     * 引用故障类型配置表
     */
    private String malfunctionType;

    /**
     * 引用故障等级配置表
     */
    private String malfunctionLevel;

    /**
     * 引用人员
     */
    private Integer auditor;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 引用人员
     */
    private Integer dispatcher;

    /**
     * 分派时间
     */
    private Date dispatchTime;

    /**
     * 分派信息
     */
    private String dispatchInfo;

    /**
     * 截至时间
     */
    private Date maintenanceDeadline;

    /**
     * 引用人员
     */
    private Integer maintenancePersonnel;

    /**
     * 维修描述
     */
    private String maintenanceDesc;

    /**
     * 维修完成时间
     */
    private Date maintenanceFinishTime;

    /**
     * 单位小时
     */
    private String troubleshootingTime;

    /**
     * 单位小时
     */
    private String maintenanceTime;

    /**
     * 预防措施
     */
    private String precautions;

    /**
     * 引用人员
     */
    private Integer validator;

    /**
     * 验证时间
     */
    private Date validateTime;

    /**
     * 验证说明
     */
    private String validateDesc;

    /**
     * 验证判定
     */
    private String validateJudgement;

    /**
     * url
     */
    private String maintenancePhotos;

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

    public static CdMaintenance from(MaintenanceDto dto) {
        return CdMaintenance.builder()
                .code(dto.getCode())
                .equipment(Objects.nonNull(dto.getEquipment())
                        ? dto.getEquipment().getId()
                        : null)
                .submitTime(Date.from(Instant.now()))
                .malfunctionDesc(dto.getDescription())
                .malfunctionPhotos(Objects.nonNull(dto.getPicUrls()) ? Strings.join(Arrays.asList(dto.getPicUrls()), ',') : null)
                .maintenanceDesc(dto.getMaintenanceDesc())
                .maintenanceTime(dto.getPauseTime())
                .validateJudgement(dto.getValidation())
                .validateDesc(dto.getValidateDesc())
                .isDelete("0")
                .build();
    }

    public static CdMaintenance maintainFrom(MaintenanceDto dto) {
        return CdMaintenance.builder()
                .id(dto.getId())
                .malfunctionType(dto.getMalfunctionType())
                .maintenanceDesc(dto.getMaintenanceDesc())
                .maintenanceTime(dto.getPauseTime())
                .maintenancePhotos(Objects.nonNull(dto.getMaintainPicUrls())
                        ? Strings.join(Arrays.asList(dto.getMaintainPicUrls()), ',')
                        : null)
                .build();
    }

}
