package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cd_spare_part
 * @author
 */
@Data
public class CdSparePart implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 规格
     */
    private String specification;

    /**
     * 库存
     */
    private String stock;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 更换周期
     */
    private String replacementPeriod;

    /**
     * 最低库存
     */
    private String minStock;

    /**
     * 最高库存
     */
    private String maxStock;

    /**
     * 通用件
     */
    private String isUnivesal;

    /**
     * 易损件
     */
    private String isFragile;

    /**
     * 类型
     */
    private String type;

    /**
     * 使用周期
     */
    private String usePeriod;

    /**
     * 备注
     */
    private String remark;

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
