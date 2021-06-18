package com.siemens.brownfield.femanagement.entity.bf;

import java.io.Serializable;
import java.util.Date;

import com.siemens.brownfield.femanagement.dto.ProcessDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * process
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Process implements Serializable {
    private Integer id;

    private String processNum;

    private String processName;

    private String processCode;

    private String processType;

    private String groupLeader;

    private String readyTime;

    private Double maxWipQuantity;

    private String description;

    private Integer organizationId;

    private String creator;

    private Date creationTime;

    private Object extras;

    private String basicDataVersion;

    private Boolean deleted;

    /**
     * 小时率，供NCC使用
     */
    private Double hourlyRate;

    private static final long serialVersionUID = 1L;

    public static Process from(ProcessDto processDto) {
        return Process.builder()
                .id(processDto.getId())
                .groupLeader(processDto.getGroupLeader())
                .build();
    }
}
