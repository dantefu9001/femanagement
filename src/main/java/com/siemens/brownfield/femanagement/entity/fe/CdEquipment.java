package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import lombok.Builder;
import lombok.Data;

/**
 * cd_equipment
 *
 * @author
 */
@Data
@Builder
public class CdEquipment implements Serializable {
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
    private Integer equipmentGroup;

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

    public static CdEquipment from(EquipmentDto dto) {
        CdEquipment equipment = CdEquipment.builder()
                .picture(dto.getPicture())
                .code(dto.getCode())
                .name(dto.getName())
                .responsible(Objects.isNull(dto.getProductionLine()) ? null : dto.getResponsible().getId())
                .productionLine(Objects.isNull(dto.getProductionLine()) ? null : dto.getProductionLine().getId())
                .process(Objects.isNull(dto.getProcess()) ? null : dto.getProcess().getId())
                .asset(Objects.isNull(dto.getAsset()) ? null : dto.getAsset().getId())
                .equipmentGroup(Objects.isNull(dto.getEquipmentGroup()) ? null : dto.getEquipmentGroup().getId())
                .description(dto.getDescription())
                .isDelete(dto.getIsDelete())
                .isAutoDispatch(dto.getIsAutoDispatch())
                .status(dto.getStatus())
                .model(dto.getModel())
                .manufacturer(dto.getManufacturer())
                .specification(dto.getSpecification())
                .serialNumber(dto.getSerialNumber())
                .dateOfProduction(fromNullableInstant(dto.getDateOfProduction()))
                .dateOfInstallation(fromNullableInstant(dto.getDateOfInstallation()))
                .dateOfFirstUse(fromNullableInstant(dto.getDateOfFirstUse()))
                .dateOfExpiration(fromNullableInstant(dto.getDateOfExpiration()))
                .expiresYears(dto.getExpiresYears())
                .customAttributes(dto.getCustomAttributes())
                .createdBy("zenan")
                .createdTime(Date.from(Instant.now()))
                .updatedBy("zenan")
                .updatedTime(Date.from(Instant.now()))
                .build();
        if (-1 != dto.getId()) {
            equipment.setId(dto.getId());
        }
        return equipment;
    }

    private static Date fromNullableInstant(Instant instant) {
        return Date.from(Objects.isNull(instant) ? Instant.now() : instant);
    }
}
