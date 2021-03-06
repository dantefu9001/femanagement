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

    private Integer parentId;
    private Integer id;
    private String name;
    private String groupLeader;

    public ProcessDto(Integer id){
        this.id = id;
    }

    public static ProcessDto from(Process process) {
        return ProcessDto.builder()
                .id(process.getId())
                .name(process.getProcessName())
                .build();
    }
}
