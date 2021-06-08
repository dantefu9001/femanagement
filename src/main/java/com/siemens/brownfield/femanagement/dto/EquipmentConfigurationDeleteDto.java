package com.siemens.brownfield.femanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class EquipmentConfigurationDeleteDto {
    private List<Integer> ids;
    private Integer equipmentId;
}
