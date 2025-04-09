package com.batch.avcbatch.service.writer;

import com.batch.avcpersistence.dto.Sample2DTO;
import com.batch.avcpersistence.entities.Sample2Entity;
import com.batch.avcpersistence.mapper.Sample2EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Sample2Writer {

    private final Sample2EntityMapper sample2EntityMapper;

    public void writeSample2(Chunk<? extends Sample2DTO> request) {

        List<Sample2Entity> entities = Sample2Entity.toEntities(request.getItems());
        sample2EntityMapper.bulkInsertSample2(entities);
    }
}
