package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.common.CommonResult;
import com.siemens.brownfield.femanagement.dto.EquipmentSummaryDto;
import com.siemens.brownfield.femanagement.service.EquipmentsSummaryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/equipments-summary")
public class EquipmentsSummaryController {

    private final EquipmentsSummaryService equipmentsSummaryService;

    public EquipmentsSummaryController(EquipmentsSummaryService equipmentsSummaryService) {
        this.equipmentsSummaryService = equipmentsSummaryService;
    }

    @ApiOperation(value = "获取所有设备管理小结")
    @GetMapping()
    public List<EquipmentSummaryDto> getEquipmentSummary(@Nullable @RequestParam("type") String type,
                                                         @Nullable @RequestParam("summary") String summary) {
        return equipmentsSummaryService.getSummaryList(type, summary);
    }


    @PostMapping()
    public CommonResult<Boolean> addEquipment(@RequestBody EquipmentSummaryDto equipmentSummaryDto) {
        Boolean success = equipmentsSummaryService.addEquipmentSummary(equipmentSummaryDto);
        return CommonResult.<Boolean>builder()
                .data(success)
                .build();
    }
}
