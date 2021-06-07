package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cd_equipment_configuration
 * @author
 */
@Data
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
}
