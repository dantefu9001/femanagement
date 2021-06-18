package com.siemens.brownfield.femanagement.dao.bf;

import com.siemens.brownfield.femanagement.dto.AssetDto;
import com.siemens.brownfield.femanagement.entity.bf.Asset;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);

    List<Asset> getAssetList();

    void deleteAssetProcessRelationByProcessId(Integer processId);

    List<Integer> getAssetListByParentId(Integer processId);

    List<Asset> selectByIds(List<Integer> ids);

    void deleteAssetProcessRelation(@Param("id")Integer id, @Param("parentId") Integer parentId);

    void insertAssetProcessRelation(@Param("id")Integer id, @Param("parentId") Integer parentId);
}
