package com.siemens.brownfield.femanagement.entity;

import java.util.Arrays;
import java.util.Optional;

public enum MaintenanceStatus {
    SUBMITTED("已提交"),
    TO_BE_DISPATCHED("待分派"),
    DISPATCHED("已分派"),
    MAINTAINED("已维修"),
    CONFIRMED("已确认"),
    RATED("已评价"),
    VALIDATED("已验证"),
    VALIDATION_APPROVED("验证已审核");

    private String status;

    MaintenanceStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static MaintenanceStatus getLabel(String status){
        Optional<MaintenanceStatus> maintenanceStatusOptional = Arrays.stream(MaintenanceStatus.values())
                .filter(maintenanceStatus -> maintenanceStatus.getStatus().equalsIgnoreCase(status)).findFirst();
        if (maintenanceStatusOptional.isPresent()) {
            return maintenanceStatusOptional.get();
        }
        return null;
    }
}
