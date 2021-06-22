package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdSparePartDao;
import com.siemens.brownfield.femanagement.dto.SparePartDto;
import com.siemens.brownfield.femanagement.service.SparePartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SparePartsImpl implements SparePartService {

    private final CdSparePartDao cdSparePartDao;

    public SparePartsImpl(CdSparePartDao cdSparePartDao) {
        this.cdSparePartDao = cdSparePartDao;
    }

    @Override
    public List<SparePartDto> getSpareParts() {
        return cdSparePartDao.getList().stream().map(SparePartDto::from).collect(Collectors.toList());
    }
}
