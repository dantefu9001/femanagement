package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.util.Date;

import com.siemens.brownfield.femanagement.dto.EquipmentConfigurationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cd_equipment_configuration
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CdEquipmentConfiguration implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public static CdEquipmentConfiguration from(EquipmentConfigurationDto configurationDto) {
        return CdEquipmentConfiguration.builder()
                .id(configurationDto.getId())
                .equipmentId(configurationDto.getEquipmentId())
                .code(configurationDto.getCode())
                .param(configurationDto.getParam())
                .type(configurationDto.getType())
                .unit(configurationDto.getUnit())
                .max(configurationDto.getMax())
                .min(configurationDto.getMin())
                .isDelete("0")
                .build();
    }
}
