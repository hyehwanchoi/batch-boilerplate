package com.batch.avcbatch.batch;

import com.batch.avcbatch.service.Sample2Service;
import com.batch.avcbatch.service.SampleService;
import com.batch.avcpersistence.dto.Sample2DTO;
import com.batch.avcpersistence.dto.SampleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MI1Batch {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    private final SampleService sampleService;
    private final Sample2Service sample2Service;

    @Bean
    public Job sampleJob() {
        return new JobBuilder("sampleJob", jobRepository)
                .start(sampleStep(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step sampleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("sampleStep", jobRepository)
                .<SampleDTO, SampleDTO>chunk(10, transactionManager)
                .reader()
                .processor()
                .writer()
                .build();
    }

    @Bean
    public Tasklet sampleTasklet() {
        return (contribution, chunkContext) -> {

            List<SampleDTO> sample1 = sampleService.getSampleDTOList();
            System.out.println("sample size:" + sample1.size());

            List<Sample2DTO> sample2 = sample2Service.getSample2DTOList();
            System.out.println("sample2 size:" + sample2.size());

            return RepeatStatus.FINISHED;
        };
    }
}
