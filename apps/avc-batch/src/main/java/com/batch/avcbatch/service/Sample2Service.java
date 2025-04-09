package com.batch.avcbatch.service;

import com.batch.avcpersistence.dto.Sample2DTO;
import com.batch.avcpersistence.entities.Sample2Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Sample2Service {

//    private final Sample2EntityMapper sample2EntityMapper;

    public List<Sample2DTO> getSample2DTOList(String currentDateTime) {

//        List<Sample2Entity> entities = sample2EntityMapper.getSample2DTOList();
        List<Sample2Entity> entities = List.of(
                Sample2Entity.of("20250101", "테스트"),
                Sample2Entity.of("20250101", "테스트2"),
                Sample2Entity.of("20250101", "테스트"),
                Sample2Entity.of("20250101", "테스트2"),
                Sample2Entity.of("20250101", "테스트"),
                Sample2Entity.of("20250101", "테스트2"),
                Sample2Entity.of("20250101", "테스트"),
                Sample2Entity.of("20250101", "테스트2"),
                Sample2Entity.of("20250101", "테스트"),
                Sample2Entity.of("20250101", "테스트2"),
                Sample2Entity.of("20250101", "테스트"),
                Sample2Entity.of("20250101", "테스트2")

        );

        return Sample2DTO.fromEntities(entities);
    }
}
