package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDto {

    private List<Integer> ids;
    private Integer id;
    private String code;
    private ProductionLineDto productionLine;
    private ProcessDto process;
    private EquipmentDto equipment;
    private String nonEquipment;
    private String malfunctionTime;
    private String description;
    private PersonDto submitter;
    private String malfunctionType;
    private String rating;
    private String status;
    private String[] picUrls;

    public static MaintenanceDto from(CdMaintenance cdMaintenance) {
        return MaintenanceDto.builder()
                .id(cdMaintenance.getId())
                .code(cdMaintenance.getCode())
                .description(cdMaintenance.getMalfunctionDesc())
                .malfunctionTime(Objects.nonNull(cdMaintenance.getSubmitTime())
                        ? new SimpleDateFormat("yyyy-MM-dd").format(cdMaintenance.getSubmitTime())
                        : "")
                .picUrls(Objects.nonNull(cdMaintenance.getMalfunctionPhotos()) ? cdMaintenance.getMalfunctionPhotos().split(",") : null)
                .build();
    }
}
