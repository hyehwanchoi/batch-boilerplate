package com.batch.avcpersistence.entities;

import com.batch.avcpersistence.dto.Sample2DTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sample2Entity {

    private String strgYmd;
    private String name;

    public static Sample2Entity of(String strgYmd, String name) {

        return new Sample2Entity(strgYmd, name);
    }

    public static List<Sample2Entity> toEntities(List<? extends Sample2DTO> list) {

        return list.stream()
                .map(Sample2Entity::toEntity)
                .collect(Collectors.toList());
    }

    public static Sample2Entity toEntity(Sample2DTO sample2DTO) {

        return Sample2Entity.of(sample2DTO.getStrgYmd(), sample2DTO.getName());
    }
}
