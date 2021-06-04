package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentBasicPicture;

import java.util.List;

public interface CdEquipmentBasicPictureDao {
    int insert(CdEquipmentBasicPicture record);

    int insertSelective(CdEquipmentBasicPicture record);

    List<Object> getFiles();
}
