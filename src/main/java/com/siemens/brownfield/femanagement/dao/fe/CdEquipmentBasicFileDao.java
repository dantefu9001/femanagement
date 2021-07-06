package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdEquipmentBasicFile;

public interface CdEquipmentBasicFileDao {
    int deleteByPrimaryKey(String fileId);

    int insert(CdEquipmentBasicFile record);

    int insertSelective(CdEquipmentBasicFile record);

    CdEquipmentBasicFile selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(CdEquipmentBasicFile record);

    int updateByPrimaryKey(CdEquipmentBasicFile record);

}
