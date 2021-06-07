package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentGroupDto {

    private Integer id;
    private String name;

    public static EquipmentGroupDto from(CdEquipmentGroup cdEquipmentGroup) {
        return EquipmentGroupDto.builder()
                .id(cdEquipmentGroup.getId())
                .name(cdEquipmentGroup.getName())
                .build();
    }
}
