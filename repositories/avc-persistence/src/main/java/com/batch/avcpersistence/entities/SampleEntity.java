package com.batch.avcpersistence.entities;

import com.batch.avcpersistence.dto.SampleDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@Table(name = "sample")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    public static SampleEntity of(SampleDTO sampleDTO) {
        SampleEntity entity = new SampleEntity();
        entity.name = sampleDTO.getName();
        entity.description = sampleDTO.getDescription();

        return entity;
    }

    public static List<SampleEntity> toEntities(List<? extends SampleDTO> list) {

        return list.stream()
                .map(SampleEntity::toEntity)
                .collect(Collectors.toList());
    }

    public static SampleEntity toEntity(SampleDTO sampleDTO) {

        return SampleEntity.of(sampleDTO);
    }
}
