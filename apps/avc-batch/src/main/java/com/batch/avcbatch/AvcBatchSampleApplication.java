package com.batch.avcbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AvcBatchSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvcBatchSampleApplication.class, args);
    }
}
