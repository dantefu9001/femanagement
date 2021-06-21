package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceResDto {

    private Integer id;
    private String code;
    private String productionLine;
    private String equipment;
    private String nonEquipment;
    private String malfunctionTime;
    private String description;
    private String maintainer;
    private String malfunctionType;
    private String rating;
    private String status;
    private String[] picUrls;

    public static MaintenanceResDto from(CdMaintenance cdMaintenance) {
        return MaintenanceResDto.builder()
                .id(cdMaintenance.getId())
                .code(cdMaintenance.getCode())
                .build();
    }
}
