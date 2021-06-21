package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDto {

    private Integer id;
    private String code;
    private ProductionLineDto productionLine;
    private EquipmentDto equipment;
    private String nonEquipment;
    private String malfunctionTime;
    private String description;
    private PersonDto maintainer;
    private String malfunctionType;
    private String rating;
    private String status;
    private String[] picUrls;

    public static MaintenanceDto from(CdMaintenance cdMaintenance) {
        return MaintenanceDto.builder()
                .id(cdMaintenance.getId())
                .code(cdMaintenance.getCode())
                .description(cdMaintenance.getMalfunctionDesc())
                .malfunctionTime(Objects.nonNull(cdMaintenance.getSubmitTime()) ? cdMaintenance.getSubmitTime().toString() : "")
                .picUrls(Objects.nonNull(cdMaintenance.getMalfunctionPhotos()) ? cdMaintenance.getMalfunctionPhotos().split(",") : null)
                .build();
    }
}
