package com.batch.avcbatch.service.writer;

import com.batch.avcpersistence.dto.Sample2DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Sample2ItemWriter implements ItemWriter<Sample2DTO> {

    private final Sample2Writer sample2Writer;

    @Override
    public void write(Chunk<? extends Sample2DTO> chunk) {

        sample2Writer.writeSample2(chunk);
    }
}
