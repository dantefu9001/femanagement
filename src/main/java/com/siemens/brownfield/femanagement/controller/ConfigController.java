package com.siemens.brownfield.femanagement.controller;

import com.siemens.brownfield.femanagement.dao.fe.CdBasicConfigsDao;
import com.siemens.brownfield.femanagement.dto.CdBasicConfigDto;
import com.siemens.brownfield.femanagement.entity.fe.CdBasicConfigs;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/config")
public class ConfigController {

    private final CdBasicConfigsDao cdBasicConfigsDao;

    public ConfigController(CdBasicConfigsDao cdBasicConfigsDao) {
        this.cdBasicConfigsDao = cdBasicConfigsDao;
    }

    @GetMapping
    public CdBasicConfigDto getConfig() {
        return CdBasicConfigDto.from(cdBasicConfigsDao.getConfig());
    }

    @PostMapping
    public void setConfig(@RequestBody CdBasicConfigDto dto) {
        cdBasicConfigsDao.update(CdBasicConfigs.from(dto));
    }
}
