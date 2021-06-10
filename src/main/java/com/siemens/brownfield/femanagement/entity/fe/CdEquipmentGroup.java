package com.siemens.brownfield.femanagement.entity.fe;

import java.io.Serializable;
import java.util.Date;

import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.dto.EquipmentGroupDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cd_equipment_group
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CdEquipmentGroup implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

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
     * 软删除标识符
     */
    private String isDelete;

    /**
     * 引用机构表
     */
    private Integer enterprise;

    private static final long serialVersionUID = 1L;

    public static CdEquipmentGroup from(EquipmentGroupDto equipmentDto) {
        return CdEquipmentGroup.builder()
                .id(equipmentDto.getId())
                .name(equipmentDto.getName())
                .build();
    }
}
