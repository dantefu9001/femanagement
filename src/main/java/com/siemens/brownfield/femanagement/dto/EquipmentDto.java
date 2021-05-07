package com.siemens.brownfield.femanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto {
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
    private Instant dateOfProduction;

    /**
     * 安装日期
     */
    private Instant dateOfInstallation;

    /**
     * 首次使用
     */
    private Instant dateOfFirstUse;

    /**
     * 报废年限
     */
    private Integer expiresYears;

    /**
     * 报废期限
     */
    private Instant dateOfExpiration ;

    /**
     * json格式的自定义属性
     */
    private String customAttributes;
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
