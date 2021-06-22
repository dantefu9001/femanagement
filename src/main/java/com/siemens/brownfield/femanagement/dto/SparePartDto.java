package com.siemens.brownfield.femanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SparePartDto {
//    id: number,
//    code: string,
//    name: string,
//    stock: number,
//    unit: string,
//    consumption: number,
//    period: number,
//    remark: string,
    private Integer id;
    private String code;
    private String name;
    private Integer stock;
    private Integer consumption;
    private String unit;
    private Integer period;
    private String remark;


}
