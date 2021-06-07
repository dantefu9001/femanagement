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

    private String name;
    private Integer id;

    public static AssetDto from(Asset asset) {
        return AssetDto.builder().id(asset.getId()).name(asset.getAssetName()).build();
    }
}