package com.china317.myspringboot5.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
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
@Configuration
@EnableConfigurationProperties(JpaProperties.class)
public class EntityManagerFactoryConfig {
    private static final Logger logger = LoggerFactory.getLogger(EntityManagerFactoryConfig.class);
    @Autowired
    private JpaProperties jpaProperties;
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("mainDataSource")DataSource dataSource) {
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
            EntityManagerFactoryBuilder builder, @Qualifier("secondDataSource")DataSource dataSource) {
        logger.info("secondEntityManagerFactory init..");
        return builder
                .dataSource(dataSource)
                .packages("com.china317.myspringboot5.entity.second")
                .persistenceUnit("secondPersistenceUnit")
                .properties(jpaProperties.getHibernateProperties(dataSource))// 因为自定义数据源，所以配置没有自动生成，手动生成
                .build();
    }
}
