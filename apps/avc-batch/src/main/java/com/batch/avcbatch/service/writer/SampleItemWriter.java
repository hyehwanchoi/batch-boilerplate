package com.batch.avcbatch.service.writer;

import com.batch.avcpersistence.dto.SampleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleItemWriter implements ItemWriter<SampleDTO> {

    private final SampleWriter sampleWriter;

    @Override
    public void write(Chunk<? extends SampleDTO> chunk) {

        sampleWriter.writeSample(chunk);
    }
}
