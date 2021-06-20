package com.siemens.brownfield.femanagement.dao.fe;

import com.siemens.brownfield.femanagement.entity.fe.CdBasicConfigs;

public interface CdBasicConfigsDao {
    int insert(CdBasicConfigs record);

    int insertSelective(CdBasicConfigs record);

    CdBasicConfigs getConfig();

    void update(CdBasicConfigs configs);
}
