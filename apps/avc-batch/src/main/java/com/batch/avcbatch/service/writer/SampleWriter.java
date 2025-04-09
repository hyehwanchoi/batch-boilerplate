package com.batch.avcbatch.service.writer;

import com.batch.avcpersistence.dto.SampleDTO;
import com.batch.avcpersistence.entities.SampleEntity;
import com.batch.avcpersistence.entities.repository.SampleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SampleWriter {

    private final SampleEntityRepository sampleEntityRepository;

    public void writeSample(Chunk<? extends SampleDTO> request) {

        List<SampleEntity> entities = SampleEntity.toEntities(request.getItems());
        sampleEntityRepository.saveAll(entities);
    }
}
