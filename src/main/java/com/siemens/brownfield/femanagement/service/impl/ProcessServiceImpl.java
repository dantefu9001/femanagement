package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.ProcessDao;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.entity.bf.Process;
import com.siemens.brownfield.femanagement.service.ProcessService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessServiceImpl implements ProcessService {

    private final ProcessDao processDao;

    public ProcessServiceImpl(ProcessDao processDao) {
        this.processDao = processDao;
    }

    @Override
    public List<ProcessDto> getProcessList() {
        List<Process> processes =  processDao.getProcessList();
        return processes.stream()
                .map(ProcessDto::from)
                .collect(Collectors.toList());
    }
}
