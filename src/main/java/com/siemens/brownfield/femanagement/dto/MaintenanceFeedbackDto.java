package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.fe.CdMaintenanceFeedback;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceFeedbackDto {

    private Integer id;
    /**
     * 响应性
     */
    private Double responseRating;

    /**
     * 维修质量
     */
    private Double qualityRating;

    /**
     * 现场5S
     */
    private Double fiveSRating;

    /**
     * 总体评价
     */
    private Double overallRating;

    /**
     * 补充说明
     */
    private String description;
    /**
     * 评价人
     */
    private PersonDto ratePerson;

    private String rateDate;

    public static MaintenanceFeedbackDto from(CdMaintenanceFeedback feedback) {
        return MaintenanceFeedbackDto.builder()
                .id(feedback.getId())
                .responseRating(Double.valueOf(feedback.getResponse()))
                .qualityRating(Double.valueOf(feedback.getQuality()))
                .fiveSRating(Double.valueOf(feedback.getOnsiteManagement()))
                .overallRating(Double.valueOf(feedback.getOverall()))
                .description(feedback.getDescription())
                .rateDate(Objects.isNull(feedback.getCreatedTime())
                        ? ""
                        : feedback.getCreatedTime().toString())
                .ratePerson(PersonDto.builder()
                        .id(Integer.valueOf(feedback.getProvider()))
                        .build())
                .build();
    }
}
