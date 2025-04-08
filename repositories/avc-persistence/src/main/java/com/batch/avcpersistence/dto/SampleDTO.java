package com.batch.avcpersistence.dto;

import com.batch.avcpersistence.entities.SampleEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SampleDTO {

    private String name;
    private String description;

    public static SampleDTO fromEntity(SampleEntity entity) {
        return new SampleDTO(entity.getName(), entity.getDescription());
    }

    public static List<SampleDTO> fromEntities(List<SampleEntity> entities) {
        return entities.stream()
                .map(SampleDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
