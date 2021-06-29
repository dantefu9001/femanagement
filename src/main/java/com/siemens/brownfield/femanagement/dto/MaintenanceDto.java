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
    private String description;//故障描述
    private PersonDto submitter;
    private String malfunctionType;
    private String malfunctionLevel;
    private String rating;
    private String status;
    //新增维修单上传的图片
    private String[] picUrls;
    private String maintenanceDesc;
    private String pauseTime;
    //进行维护时上传的图片
    private String[] maintainPicUrls;
    private SparePartDto[] spareParts;

    private String responseRating;
    private String qualityRating;
    private String fiveSRating;
    private String overallRating;
    private PersonDto provider;
    private Boolean isAnonymous;
    private String rateTime;
    private String rateDescription;

    private String validation;
    private String validateDesc;

    private PersonDto maintenancePerson;
    private String deadLine;
    private String dispatchTime;
    private PersonDto dispatcher;
    private String dispatchInfo;
    private String precautions;

    public static MaintenanceDto from(CdMaintenance cdMaintenance) {
        return MaintenanceDto.builder()
                .id(cdMaintenance.getId())
                .code(cdMaintenance.getCode())
                .description(cdMaintenance.getMalfunctionDesc())
                .status(cdMaintenance.getStatus())
                .malfunctionTime(Objects.nonNull(cdMaintenance.getSubmitTime())
                        ? new SimpleDateFormat("yyyy-MM-dd").format(cdMaintenance.getSubmitTime())
                        : "")
                .picUrls(Objects.nonNull(cdMaintenance.getMalfunctionPhotos()) ? cdMaintenance.getMalfunctionPhotos().split(",") : null)
                .build();
    }
}
