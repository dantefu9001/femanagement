package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.PersonDao;
import com.siemens.brownfield.femanagement.dao.bf.ProcessDao;
import com.siemens.brownfield.femanagement.dao.bf.ProductionLineDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentGroupDao;
import com.siemens.brownfield.femanagement.dao.fe.CdMaintenanceConsumptionDao;
import com.siemens.brownfield.femanagement.dao.fe.CdMaintenanceDao;
import com.siemens.brownfield.femanagement.dao.fe.CdMaintenanceFeedbackDao;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.dto.MaintenanceDto;
import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.dto.SparePartDto;
import com.siemens.brownfield.femanagement.entity.MaintenanceStatus;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.entity.fe.CdMaintenance;
import com.siemens.brownfield.femanagement.entity.fe.CdMaintenanceConsumption;
import com.siemens.brownfield.femanagement.entity.fe.CdMaintenanceFeedback;
import com.siemens.brownfield.femanagement.service.MaintenanceService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final CdEquipmentDao cdEquipmentDao;
    private final CdMaintenanceDao cdMaintenanceDao;
    private final CdEquipmentGroupDao cdEquipmentGroupDao;
    private final PersonDao personDao;
    private final ProductionLineDao productionLineDao;
    private final ProcessDao processDao;
    private final CdMaintenanceConsumptionDao cdMaintenanceConsumptionDao;
    private final CdMaintenanceFeedbackDao cdMaintenanceFeedbackDao;


    public MaintenanceServiceImpl(CdEquipmentDao cdEquipmentDao, CdMaintenanceDao cdMaintenanceDao, CdEquipmentGroupDao cdEquipmentGroupDao, PersonDao personDao, ProductionLineDao productionLineDao, ProcessDao processDao, CdMaintenanceConsumptionDao cdMaintenanceConsumptionDao, CdMaintenanceFeedbackDao cdMaintenanceFeedbackDao) {
        this.cdEquipmentDao = cdEquipmentDao;
        this.cdMaintenanceDao = cdMaintenanceDao;
        this.cdEquipmentGroupDao = cdEquipmentGroupDao;
        this.personDao = personDao;
        this.productionLineDao = productionLineDao;
        this.processDao = processDao;
        this.cdMaintenanceConsumptionDao = cdMaintenanceConsumptionDao;
        this.cdMaintenanceFeedbackDao = cdMaintenanceFeedbackDao;
    }

    @Override
    public List<MaintenanceDto> getMaintenanceList(String start, String end, List<String> status, String equipment, String group) {
        if (Strings.isNotEmpty((start))) {
            start = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.parse(start)));
        }
        if (Strings.isNotEmpty(end)) {
            end = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.parse(end)));
        }
        return cdMaintenanceDao.getList(equipment, group, status, start, end).parallelStream().map(maintenance -> {
            MaintenanceDto dto = MaintenanceDto.from(maintenance);
            CdEquipment cdEquipment = cdEquipmentDao.selectByPrimaryKey(maintenance.getEquipment());
            if (Objects.nonNull(cdEquipment)) {
                dto.setEquipment(EquipmentDto.from(cdEquipment));
                Optional.of(productionLineDao.selectByPrimaryKey(cdEquipment.getProductionLine())).ifPresent(cdProductionLine -> dto.setProductionLine(ProductionLineDto.from(cdProductionLine)));
                Optional.of(processDao.selectByPrimaryKey(cdEquipment.getProcess())).ifPresent(cdProcess -> dto.setProcess(ProcessDto.from(cdProcess)));
                Optional.of(personDao.selectByPrimaryKey(cdEquipment.getResponsible())).ifPresent(cdPerson -> dto.setSubmitter(PersonDto.from(cdPerson)));
            }
            return dto;
        }).sorted(Comparator.comparing(MaintenanceDto::getSubmitTime).reversed()).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(MaintenanceDto dto) {
        CdMaintenance cdMaintenance = CdMaintenance.from(dto);
        cdMaintenance.setStatus(MaintenanceStatus.SUBMITTED.getStatus());
        cdMaintenanceDao.insertSelective(cdMaintenance);
    }

    @Override
    public void delete(List<Integer> ids) {
        if (ids.size() == 0) {
            return;
        }
        cdMaintenanceDao.batchSoftDelete(ids);
    }

    @Override
    public void audit(List<Integer> ids) {
        if (ids.size() == 0) {
            return;
        }
        cdMaintenanceDao.audit(ids);
    }

    @Override
    public void maintain(MaintenanceDto dto) {
        updateMaintenanceStatus(dto);
        if (Objects.nonNull(dto.getSpareParts()) && dto.getSpareParts().length > 0) {
            List<SparePartDto> dtos = Arrays.asList(dto.getSpareParts());
            List<CdMaintenanceConsumption> cdMaintenanceConsumptions = dtos.parallelStream().map(sparePartDto -> CdMaintenanceConsumption.builder()
                    .maintenance(dto.getId())
                    .sparePart(sparePartDto.getId())
                    .number(sparePartDto.getConsumption())
                    .build()).collect(Collectors.toList());
            cdMaintenanceConsumptions.forEach(cdMaintenanceConsumptionDao::insertSelective);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rate(MaintenanceDto dto) {
        CdMaintenanceFeedback feedback = CdMaintenanceFeedback.builder()
                .maintenance(dto.getId())
                .overall(dto.getOverallRating())
                .onsiteManagement(dto.getFiveSRating())
                .quality(dto.getQualityRating())
                .response(dto.getResponseRating())
                .description(dto.getDescription())
                .isAnonymous(String.valueOf(dto.getIsAnonymous()))
                .provider(Objects.nonNull(dto.getProvider())
                        ? dto.getProvider().getName() :
                        "")
                .build();
        updateMaintenanceStatus(dto);
        cdMaintenanceFeedbackDao.insertSelective(feedback);
    }

    @Override
    public void updateStatus(MaintenanceDto dto) {
        updateMaintenanceStatus(dto);
    }

    @Override
    public void validateBySubmitter(MaintenanceDto dto) {
        CdMaintenance maintenance = CdMaintenance.from(dto);
        maintenance.setId(dto.getId());
        cdMaintenanceDao.updateByPrimaryKeySelective(maintenance);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void approveValidation(List<Integer> ids) {
        ids.parallelStream().forEach(id -> {
            CdMaintenance cdMaintenance = CdMaintenance.builder().id(id).build();
            cdMaintenance.setStatus(MaintenanceStatus.VALIDATION_APPROVED.getStatus());
            cdMaintenanceDao.updateByPrimaryKeySelective(cdMaintenance);
        });
    }

    @Override
    public void dispatch(MaintenanceDto dto) {
        CdMaintenance cdMaintenance = CdMaintenance.dispatchFrom(dto);
        cdMaintenanceDao.updateByPrimaryKeySelective(cdMaintenance);
    }

    @Override
    public void confirmDispatch(MaintenanceDto dto) {
        updateMaintenanceStatus(dto);
    }

    private void updateMaintenanceStatus(MaintenanceDto dto) {
        CdMaintenance maintenance = cdMaintenanceDao.selectByPrimaryKey(dto.getId());
        maintenance.setStatus(dto.getStatus());
        cdMaintenanceDao.updateByPrimaryKey(maintenance);
    }
}
