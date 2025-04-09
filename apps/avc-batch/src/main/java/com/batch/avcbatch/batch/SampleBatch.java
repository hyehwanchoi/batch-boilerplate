package com.batch.avcbatch.batch;

import com.batch.avcbatch.service.Sample2Service;
import com.batch.avcbatch.service.SampleService;
import com.batch.avcbatch.service.writer.Sample2ItemWriter;
import com.batch.avcbatch.service.writer.SampleItemWriter;
import com.batch.avcpersistence.dto.Sample2DTO;
import com.batch.avcpersistence.dto.SampleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SampleBatch {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    private final SampleService sampleService;
    private final Sample2Service sample2Service;

    private final SampleItemWriter sampleItemWriter;
    private final Sample2ItemWriter sample2ItemWriter;

    @Value("${size.chunk}")
    private int chunkSize;

    @Bean
    public Job sampleJob() {
        return new JobBuilder("sampleJob", jobRepository)
                .start(sampleStep(jobRepository, transactionManager))
                .next(sample2Step(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step sampleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {

        return new StepBuilder("sampleStep", jobRepository)
                .<SampleDTO, SampleDTO>chunk(chunkSize, transactionManager)
                .reader(createSample(null))
//                .processor()
                .writer(sampleItemWriter)
                .build();
    }

    @Bean
    @StepScope
    public ItemReader<SampleDTO> createSample(@Value("#{jobParameters['currentDateTime']}") String currentDateTime) {
        List<SampleDTO> list = sampleService.getSampleDTOList(currentDateTime);

        return new ListItemReader<>(list);
    }

    @Bean
    public Step sample2Step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {

        return new StepBuilder("sample2Step", jobRepository)
                .<Sample2DTO, Sample2DTO>chunk(chunkSize, transactionManager)
                .reader(createSample2(null))
                .writer(sample2ItemWriter)
                .build();
    }

    private ItemReader<? extends Sample2DTO> createSample2(@Value("#{jobParameters['currentDateTime']}") String currentDateTime) {

        return new ListItemReader<>(sample2Service.getSample2DTOList(currentDateTime));
    }
}
