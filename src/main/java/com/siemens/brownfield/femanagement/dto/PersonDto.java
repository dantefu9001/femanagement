package com.siemens.brownfield.femanagement.dto;

import com.siemens.brownfield.femanagement.entity.bf.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    public PersonDto(String id){
        this.id = Integer.valueOf(id);
    }

    private Integer id;
    private String name;

    public static PersonDto from(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getUsername())
                .build();
    }
}
