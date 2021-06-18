package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdBasicConfigs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.json.GsonJsonParser;
import springfox.documentation.spring.web.json.Json;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CdBasicConfigDto {

    private boolean easyMode;
    private Boolean autoDispatch;
    private Boolean enableValidation;
    private Boolean maintenanceAlarm;
    private String waitTime;
    private String downTime;
    private String dispatchTime;
    private String malfunctionType;
    private String malfunctionLevel;
    private Boolean equipmentSummary;
    private Boolean sparePartManagement;

    public static CdBasicConfigDto from(CdBasicConfigs config) {
        return CdBasicConfigDto.builder()
                .easyMode(config.getEasyMode())
                .autoDispatch(config.getAutoDispatch())
                .enableValidation(config.getEnableValidation())
                .maintenanceAlarm(config.getMaintenanceAlarm())
                .waitTime(config.getMaintenanceWaiting())
                .downTime(config.getDownTime())
                .dispatchTime(config.getMaintenanceDispatchTime())
                .malfunctionType(config.getMalfunctionTypes())
                .malfunctionLevel(config.getMalfunctionLevel())
                .equipmentSummary(config.getEquipmentManagementSummary())
                .sparePartManagement(config.getSparePartManagement())
                .build();
    }
}
