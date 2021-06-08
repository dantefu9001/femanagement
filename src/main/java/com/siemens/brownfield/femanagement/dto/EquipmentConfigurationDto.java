package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentConfiguration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * cd_equipment_configuration
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentConfigurationDto {
    /**
     * id
     */
    private Integer id;

    /**
     * 引用设备
     */
    private Integer equipmentId;

    /**
     * 编号
     */
    private String code;

    /**
     * 参数
     */
    private String param;

    /**
     * 类型
     */
    private String type;

    /**
     * 单位
     */
    private String unit;

    /**
     * 上限
     */
    private String max;

    /**
     * 下限
     */
    private String min;

    /**
     * 默认值
     */
    private String defaultValue;

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

    public static EquipmentConfigurationDto from(CdEquipmentConfiguration configuration) {
        return EquipmentConfigurationDto.builder()
                .id(configuration.getId())
                .equipmentId(configuration.getEquipmentId())
                .code(configuration.getCode())
                .param(configuration.getParam())
                .type(configuration.getType())
                .unit(configuration.getUnit())
                .max(configuration.getMax())
                .min(configuration.getMin())
                .isDelete("0")
                .build();
    }

}
