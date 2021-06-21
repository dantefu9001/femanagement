package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.bf.Asset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetDto {

    private Integer parentId;
    private String name;
    private Integer id;
    private String groupLeader;

    public AssetDto(Integer id){
        this.id = id;
    }

    public static AssetDto from(Asset asset) {
        return AssetDto.builder().id(asset.getId()).name(asset.getAssetName()).build();
    }
}
