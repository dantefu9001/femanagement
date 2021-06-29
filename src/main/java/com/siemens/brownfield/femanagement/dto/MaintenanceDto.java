package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private String submitTime;
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
    private String deadline;
    private String dispatchTime;
    private PersonDto dispatcher;
    private String dispatchInfo;
    private String precaution;
    private String finishTime;
    private PersonDto checker;
    private String checkDate;
    private PersonDto validator;
    private String validateTime;

    public static MaintenanceDto from(CdMaintenance cdMaintenance) {
        return MaintenanceDto.builder()
                .id(cdMaintenance.getId())
                .code(cdMaintenance.getCode())
                .description(cdMaintenance.getMalfunctionDesc())
                .status(cdMaintenance.getStatus())
                .malfunctionTime(formatDate(cdMaintenance.getSubmitTime()))
                .submitTime(formatDate(cdMaintenance.getSubmitTime()))
                .picUrls(Objects.nonNull(cdMaintenance.getMalfunctionPhotos()) ? cdMaintenance.getMalfunctionPhotos().split(",") : null)
                .maintenancePerson(PersonDto.builder().id(cdMaintenance.getMaintenancePersonnel()).build())
                .dispatchTime(formatDate(cdMaintenance.getDispatchTime()))
                .dispatcher(PersonDto.builder().id(cdMaintenance.getDispatcher()).build())
                .malfunctionType(cdMaintenance.getMalfunctionType())
                .malfunctionLevel(cdMaintenance.getMalfunctionLevel())
                .deadline(formatDate(cdMaintenance.getMaintenanceDeadline()))
                .maintenanceDesc(cdMaintenance.getMaintenanceDesc())
                .pauseTime(cdMaintenance.getMaintenanceTime())
                .finishTime(formatDate(cdMaintenance.getMaintenanceFinishTime()))
                .checker(PersonDto.builder().id(cdMaintenance.getSubmitter()).build())
                .checkDate(formatDate(cdMaintenance.getUpdatedTime()))
                .maintenanceDesc(cdMaintenance.getMaintenanceDesc())
                .precaution(cdMaintenance.getPrecautions())
                .validator(PersonDto.builder().id(cdMaintenance.getValidator()).build())
                .validateTime(formatDate(cdMaintenance.getValidateTime()))
                .validateDesc(cdMaintenance.getValidateDesc())
                .validation(cdMaintenance.getValidateJudgement())
                .build();
    }

    private static String formatDate(Date date) {
        return Objects.nonNull(date) ? new SimpleDateFormat("yyyy-MM-dd").format(date) : Strings.EMPTY;
    }
}
