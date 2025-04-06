//package org.batch.fusionbatch.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.Objects;
//
//
//@Configuration
//@RequiredArgsConstructor
//public class BatchJobConfigurer {
//
//    private final DataSource dataSource;
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    public JobRepository jobRepository(PlatformTransactionManager transactionManager) throws Exception {
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTransactionManager(transactionManager);
//        factory.afterPropertiesSet();
//        return Objects.requireNonNull(factory.getObject());
//    }
//}
