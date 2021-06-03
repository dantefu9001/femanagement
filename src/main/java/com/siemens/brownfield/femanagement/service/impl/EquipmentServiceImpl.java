package com.siemens.brownfield.femanagement.service.impl;

import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentBasicPictureDao;
import com.siemens.brownfield.femanagement.dao.fe.CdEquipmentDao;
import com.siemens.brownfield.femanagement.dto.EquipmentDto;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipment;
import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentBasicPicture;
import com.siemens.brownfield.femanagement.service.EquipmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EquipmentServiceImpl implements EquipmentService {

    private final CdEquipmentDao equipmentDao;

    private final CdEquipmentBasicPictureDao equipmentBasicPictureDao;

    public EquipmentServiceImpl(CdEquipmentDao equipmentDao, CdEquipmentBasicPictureDao equipmentBasicPictureDao) {
        this.equipmentDao = equipmentDao;
        this.equipmentBasicPictureDao = equipmentBasicPictureDao;
    }

    @Override
    public List<EquipmentDto> getEquipments(String name, String code) {
        getFileByBytes();
        return equipmentDao.getEquipments(name, code).stream().map(EquipmentDto::from)
                .collect(Collectors.toList());
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
            result = (byte[])object;
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
