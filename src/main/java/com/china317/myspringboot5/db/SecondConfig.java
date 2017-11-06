package com.china317.myspringboot5.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;

/**
 * Created by lx-dong on 2017/11/6.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.china317.myspringboot5.repository.second",
        entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager")
public class SecondConfig {
    private static final Logger logger = LoggerFactory.getLogger(SecondConfig.class);
    @Autowired
    @Qualifier("secondEntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;

    @Bean
    public EntityManager secondEntityManager(){
        logger.debug("secondEntityManager init..");
        return entityManagerFactoryBean.getObject().createEntityManager();
    }

    @Bean
    public PlatformTransactionManager secondTransactionManager(){
        logger.debug("secondTransactionManager init..");
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
