package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdSparePart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SparePartDto {
    private Integer id;
    private String code;
    private String name;
    private String stock;
    private Integer consumption;
    private String unit;
    private String period;
    private String remark;


    public static SparePartDto from(CdSparePart cdSparePart) {
        return SparePartDto.builder()
                .id(cdSparePart.getId())
                .code(cdSparePart.getCode())
                .name(cdSparePart.getName())
                .stock(cdSparePart.getStock())
                .unit(cdSparePart.getUnit())
                .period(cdSparePart.getReplacementPeriod())
                .build();
    }
}
