package com.china317.myspringboot5.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by lx-dong on 2017/11/6.
 */
@Configuration
public class EntityManagerFactoryConfig {
    private static final Logger logger = LoggerFactory.getLogger(EntityManagerFactoryConfig.class);
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("mainDataSource")DataSource dataSource) {
        logger.info("mainEntityManagerFactory init..");
        return builder
                .dataSource(dataSource)
                .packages("com.china317.myspringboot5.entity.main")
                .persistenceUnit("mainPersistenceUnit")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("secondDataSource")DataSource dataSource) {
        logger.info("secondEntityManagerFactory init..");
        return builder
                .dataSource(dataSource)
                .packages("com.china317.myspringboot5.entity.second")
                .persistenceUnit("secondPersistenceUnit")
                .build();
    }
}
