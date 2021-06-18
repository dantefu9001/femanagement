package com.siemens.brownfield.femanagement.entity.fe;

import com.siemens.brownfield.femanagement.dto.CdBasicConfigDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * cd_basic_configs
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CdBasicConfigs implements Serializable {
    private Boolean easyMode;

    private Boolean autoDispatch;

    private Boolean enableValidation;

    private Boolean maintenanceAlarm;

    private String maintenanceWaiting;

    private String downTime;

    private String maintenanceDispatchTime;

    private String malfunctionTypes;

    private String malfunctionLevel;

    private Boolean equipmentManagementSummary;

    private Boolean sparePartManagement;

    private static final long serialVersionUID = 1L;

    public static com.siemens.brownfield.femanagement.entity.fe.CdBasicConfigs from(CdBasicConfigDto dto) {
        return com.siemens.brownfield.femanagement.entity.fe.CdBasicConfigs.builder()
                .easyMode(dto.isEasyMode())
                .autoDispatch(dto.getAutoDispatch())
                .enableValidation(dto.getEnableValidation())
                .maintenanceAlarm(dto.getMaintenanceAlarm())
                .maintenanceWaiting(dto.getWaitTime())
                .downTime(dto.getDownTime())
                .maintenanceDispatchTime(dto.getDispatchTime())
                .malfunctionTypes(dto.getMalfunctionType())
                .malfunctionLevel(dto.getMalfunctionLevel())
                .equipmentManagementSummary(dto.getEquipmentSummary())
                .sparePartManagement(dto.getSparePartManagement())
                .build();
    }
}
