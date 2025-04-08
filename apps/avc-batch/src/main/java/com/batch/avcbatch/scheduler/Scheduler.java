package com.batch.avcbatch.scheduler;

import com.batch.avcbatch.batch.MI1Batch;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final JobLauncher jobLauncher;
    private final MI1Batch mi1Batch;

    @Scheduled(cron = "10 * * * * *")  // 매 분 20초에 실행
    public void runMI1() throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis()) // 중복 실행 방지용
                .toJobParameters();

        jobLauncher.run(mi1Batch.sampleJob(), params);
    }
}
