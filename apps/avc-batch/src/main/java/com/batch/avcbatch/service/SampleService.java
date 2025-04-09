package com.batch.avcbatch.service;

import com.batch.avcpersistence.dto.SampleDTO;
import com.batch.avcpersistence.entities.SampleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

//    private final SampleEntityRepository sampleEntityRepository;

    public List<SampleDTO> getSampleDTOList(String currentDateTime) {

//        List<SampleEntity> entities = sampleEntityRepository.findAll();
        List<SampleDTO> list = Arrays.asList(
                SampleDTO.of("apple", "과일입니다."),
                SampleDTO.of("car", "탈것입니다."),
                SampleDTO.of("java", "프로그래밍 언어입니다.")
        );
        List<SampleEntity> entities = SampleEntity.toEntities(list);

        return SampleDTO.fromEntities(entities);
    }
}
