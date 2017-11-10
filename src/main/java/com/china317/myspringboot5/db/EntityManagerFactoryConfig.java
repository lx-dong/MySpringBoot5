package com.china317.myspringboot5.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by lx-dong on 2017/11/6.
 */
/* 目前是共用一个 EntityManagerFactoryBuilder 和 JpaProperties, 在 JpaBaseConfiguration 中自动创建 */
@Configuration
public class EntityManagerFactoryConfig {
    private static final Logger logger = LoggerFactory.getLogger(EntityManagerFactoryConfig.class);

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("mainDataSource")DataSource dataSource, JpaProperties jpaProperties) {
        logger.info("mainEntityManagerFactory init..");
        return builder
                .dataSource(dataSource)
                .packages("com.china317.myspringboot5.entity.main")
                .persistenceUnit("mainPersistenceUnit")
                .properties(jpaProperties.getHibernateProperties(dataSource)) // 因为自定义数据源，所以配置没有自动生成，手动生成
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("secondDataSource")DataSource dataSource, JpaProperties jpaProperties) {
        logger.info("secondEntityManagerFactory init..");
        return builder
                .dataSource(dataSource)
                .packages("com.china317.myspringboot5.entity.second")
                .persistenceUnit("secondPersistenceUnit")
                .properties(jpaProperties.getHibernateProperties(dataSource))// 因为自定义数据源，所以配置没有自动生成，手动生成
                .build();
    }

}
