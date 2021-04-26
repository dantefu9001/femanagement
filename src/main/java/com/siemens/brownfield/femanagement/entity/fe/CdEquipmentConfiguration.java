package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cd_equipment
 * @author
 */
@Data
public class CdEquipmentConfiguration implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 图片的url
     */
    private String picture;

    /**
     * fromBF
     */
    private String code;

    /**
     * fromBF
     */
    private String name;

    /**
     * fromBF
     */
    private Integer responsible;

    /**
     * fromBF
     */
    private Integer productionLine;

    /**
     * fromBF
     */
    private Integer process;

    /**
     * fromBF
     */
    private Integer asset;

    /**
     * 设备组
     */
    private Integer equipmentGroups;

    /**
     * 描述
     */
    private String description;

    /**
     * 自动分派
     */
    private String isAutoDispatch;

    /**
     * 引用状态表
     */
    private Integer status;

    /**
     * 型号
     */
    private String model;

    /**
     * 厂家
     */
    private String manufacturer;

    /**
     * 规格
     */
    private String specification;

    /**
     * 出厂编号
     */
    private String serialNumber;

    /**
     * 出厂日期
     */
    private Date dateOfProduction;

    /**
     * 安装日期
     */
    private Date dateOfInstallation;

    /**
     * 首次使用
     */
    private Date dateOfFirstUse;

    /**
     * 报废年限
     */
    private Integer expiresYears;

    /**
     * 报废期限
     */
    private Date dateOfExpiration;

    /**
     * json格式的自定义属性
     */
    private String customAttributes;

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

    private static final long serialVersionUID = 1L;
}
