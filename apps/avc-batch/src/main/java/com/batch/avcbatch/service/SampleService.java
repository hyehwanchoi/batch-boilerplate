package com.batch.avcbatch.service;

import com.batch.avcpersistence.dto.SampleDTO;
import com.batch.avcpersistence.entities.SampleEntity;
import com.batch.avcpersistence.entities.repository.SampleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleEntityRepository sampleEntityRepository;

    public List<SampleDTO> getSampleDTOList() {

        List<SampleEntity> entities = sampleEntityRepository.findAll();

        return SampleDTO.fromEntities(entities);
    }
}
