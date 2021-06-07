package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.bf.AssetDao;
import com.siemens.brownfield.femanagement.dao.bf.PersonDao;
import com.siemens.brownfield.femanagement.dao.bf.ProcessDao;
import com.siemens.brownfield.femanagement.dao.bf.ProductionLineDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentBasicPictureDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dto.AssetDto;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.dto.PersonDto;
import com.siemens.brownfield.femanagement.dto.ProcessDto;
import com.siemens.brownfield.femanagement.dto.ProductionLineDto;
import com.siemens.brownfield.femanagement.entity.bf.Asset;
import com.siemens.brownfield.femanagement.entity.bf.Person;
import com.siemens.brownfield.femanagement.entity.bf.Process;
import com.siemens.brownfield.femanagement.entity.bf.ProductionLine;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentBasicPicture;
import com.siemens.brownfield.femanagement.service.EquipmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EquipmentServiceImpl implements EquipmentService {

    private final CdEquipmentDao equipmentDao;

    private final CdEquipmentBasicPictureDao equipmentBasicPictureDao;

    private final ProductionLineDao productionLineDao;

    private final PersonDao personDao;

    private final ProcessDao processDao;

    private final AssetDao assetDao;

    public EquipmentServiceImpl(CdEquipmentDao equipmentDao, CdEquipmentBasicPictureDao equipmentBasicPictureDao, ProductionLineDao productionLineDao, PersonDao personDao, ProcessDao processDao, AssetDao assetDao) {
        this.equipmentDao = equipmentDao;
        this.equipmentBasicPictureDao = equipmentBasicPictureDao;
        this.productionLineDao = productionLineDao;
        this.personDao = personDao;
        this.processDao = processDao;
        this.assetDao = assetDao;
    }

    @Override
    public List<EquipmentDto> getEquipments(String name, String code) {
        List<CdEquipment> equipments = equipmentDao.getEquipments(name, code);
        List<ProductionLine> productionLines = productionLineDao.getProductionLines();
        List<Person> people = personDao.selectPersonnel();
        List<Process> processes = processDao.getProcessList();
        List<Asset> assets = assetDao.getAssetList();
        return equipments.parallelStream().map(equipment -> {
            EquipmentDto equipmentDto = EquipmentDto.from(equipment);
            Optional<ProductionLine> productionLineOptional = productionLines.stream().filter(productionLine -> productionLine.getId().equals(equipment.getProductionLine())).findAny();
            productionLineOptional.ifPresent(productionLine -> equipmentDto.setProductionLine(ProductionLineDto.from(productionLine)));
            Optional<Person> personOptional = people.stream().filter(person -> person.getId().equals(equipment.getResponsible())).findAny();
            personOptional.ifPresent(person -> equipmentDto.setResponsible(PersonDto.from(person)));
            Optional<Process> processOptional = processes.stream().filter(process -> process.getId().equals(equipment.getProcess())).findAny();
            processOptional.ifPresent(process->equipmentDto.setProcess(ProcessDto.from(process)));
            Optional<Asset> assetOptional = assets.stream().filter(asset->asset.getId().equals(equipment.getAsset())).findAny();
            assetOptional.ifPresent(asset->equipmentDto.setAsset(AssetDto.from(asset)));
            return equipmentDto;
        }).collect(Collectors.toList());
    }

    @Override
    public EquipmentDto getEquipmentById(Integer id) {
        CdEquipment equipment = equipmentDao.selectByPrimaryKey(id);
        Assert.notNull(equipment, "设备不存在");
        return EquipmentDto.builder()
                .id(equipment.getId())
                .build();
    }

    @Override
    public Boolean addEquipment(EquipmentDto equipmentDto) {
        CdEquipment equipment = CdEquipment.from(equipmentDto);
        try {
            equipmentDao.insertSelective(equipment);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean updateEquipment(EquipmentDto equipmentDto) {
        try {
            CdEquipment equipment = CdEquipment.from(equipmentDto);
            equipmentDao.updateByPrimaryKeySelective(equipment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean deleteEquipment(Integer id) {
        try {
            CdEquipment equipment = equipmentDao.selectByPrimaryKey(id);
            equipment.setIsDelete("1");
            equipmentDao.updateByPrimaryKeySelective(equipment);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }

    }

    @Override
    @Transactional
    public String savePictureAsBlob(MultipartFile file) {
        String blobId = UUID.randomUUID().toString().replace("-", "");
        try {
            CdEquipmentBasicPicture picture = new CdEquipmentBasicPicture();
            picture.setFileId(blobId);
            picture.setFileContent(file.getBytes());
            equipmentBasicPictureDao.insertSelective(picture);
            return blobId;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public void getFileByBytes() {
        byte[] result = new byte[0];
        try {
            Object object = equipmentBasicPictureDao.getFiles().get(0);
            result = (byte[]) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            file = new File("/Users/zenan/Documents/codes/git/femanagement/file.jpg");

            //输出流
            fos = new FileOutputStream(file);

            //缓冲流
            bos = new BufferedOutputStream(fos);

            //将字节数组写出
            bos.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
