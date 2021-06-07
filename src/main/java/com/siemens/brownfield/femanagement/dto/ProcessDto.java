package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.bf.Process;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessDto {

    private Integer id;
    private String name;

    public static ProcessDto from(Process process) {
        return ProcessDto.builder()
                .id(process.getId())
                .name(process.getProcessName())
                .build();
    }
}
