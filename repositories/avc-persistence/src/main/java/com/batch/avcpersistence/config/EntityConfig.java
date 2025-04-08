package com.batch.avcpersistence.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@ComponentScan({"com.batch.avcpersistence.entities"})
@EnableJpaRepositories({"com.batch.avcpersistence.entities"})
@EntityScan(basePackages = "com.batch.avcpersistence.entities")
@RequiredArgsConstructor
public class EntityConfig {

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager em) {

        return new JPAQueryFactory(em);
    }
}
