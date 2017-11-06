package com.china317.myspringboot5.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by lx-dong on 2017/11/6.
 */
@Configuration
public class DataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    @Bean
    @Primary
    @ConfigurationProperties("datasource.main")
    public DataSourceProperties mainDataSourceProperties(){
        logger.error("mainDataSourceProperties init..");
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("datasource.main")
    public DataSource mainDataSource(){
        logger.error("mainDataSource init..");
        //return DataSourceBuilder.create().build();
        return mainDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("datasource.second")
    public DataSourceProperties secondDataSourceProperties(){
        logger.error("secondDataSourceProperties init..");
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("datasource.second")
    public DataSource secondDataSource(){
        logger.error("secondDataSource init..");
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
