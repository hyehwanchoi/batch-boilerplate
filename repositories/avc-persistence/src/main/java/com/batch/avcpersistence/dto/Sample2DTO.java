package com.batch.avcpersistence.dto;

import com.batch.avcpersistence.entities.Sample2Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sample2DTO {

    private String strgYmd;
    private String name;

    public static Sample2DTO fromEntity(Sample2Entity entity) {
        return new Sample2DTO(entity.getStrgYmd(), entity.getName());
    }

    public static List<Sample2DTO> fromEntities(List<Sample2Entity> entities) {
        return entities.stream()
                .map(Sample2DTO::fromEntity)
                .collect(Collectors.toList());
    }
}
