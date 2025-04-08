package com.batch.avcbatch.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.batch.avcpersistence.mapper")
public class MapperConfig {
}
