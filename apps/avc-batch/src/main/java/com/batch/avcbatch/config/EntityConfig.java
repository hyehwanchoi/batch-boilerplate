package com.batch.avcbatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.batch.avcpersistence.config.EntityConfig.class})
public class EntityConfig {
}
