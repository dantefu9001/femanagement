package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Objects;

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
    private PersonDto responsible;

    /**
     * fromBF
     */
    private ProductionLineDto productionLine;

    /**
     * fromBF
     */
    private ProcessDto process;

    /**
     * fromBF
     */
    private AssetDto asset;

    /**
     * 设备组
     */
    private EquipmentGroupDto equipmentGroup;

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
    private Instant dateOfExpiration;

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

    /**
     * 设备手册
     */
    private String equipmentManifest;

    /**
     * 维修手册
     */
    private String maintenanceManifest;

    public EquipmentDto(String id){
        this.id = Integer.valueOf(id);
    }

    public static EquipmentDto from(CdEquipment equipment) {
        return EquipmentDto.builder()
                .id(equipment.getId())
                .picture(equipment.getPicture())
                .equipmentManifest(equipment.getEquipmentManifest())
                .maintenanceManifest(equipment.getMaintenanceManifest())
                .code(equipment.getCode())
                .name(equipment.getName())
                .description(equipment.getDescription())
                .isAutoDispatch(equipment.getIsAutoDispatch())
                .status(equipment.getStatus())
                .model(equipment.getModel())
                .manufacturer(equipment.getManufacturer())
                .specification(equipment.getSpecification())
                .serialNumber(equipment.getSerialNumber())
                .dateOfProduction(Objects.isNull(equipment.getDateOfProduction()) ? null : equipment.getDateOfProduction().toInstant())
                .dateOfInstallation(Objects.isNull(equipment.getDateOfInstallation()) ? null : equipment.getDateOfInstallation().toInstant())
                .dateOfFirstUse(Objects.isNull(equipment.getDateOfFirstUse()) ? null : equipment.getDateOfFirstUse().toInstant())
                .dateOfExpiration(Objects.isNull(equipment.getDateOfExpiration()) ? null : equipment.getDateOfExpiration().toInstant())
                .expiresYears(equipment.getExpiresYears())
                .customAttributes(equipment.getCustomAttributes())
                .build();
    }
}
