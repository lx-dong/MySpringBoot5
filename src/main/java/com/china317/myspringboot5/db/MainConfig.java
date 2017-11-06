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
@EnableJpaRepositories(basePackages = "com.china317.myspringboot5.repository.main",
        entityManagerFactoryRef = "mainEntityManagerFactory",
        transactionManagerRef = "mainTransactionManager")
public class MainConfig {
        private static final Logger logger = LoggerFactory.getLogger(MainConfig.class);
        @Autowired
        @Qualifier("mainEntityManagerFactory")
        private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;

        @Bean
        @Primary
        public EntityManager mainEntityManager(){
                logger.debug("mainEntityManger init..");
                return entityManagerFactoryBean.getObject().createEntityManager();
        }

        @Primary
        @Bean
        public PlatformTransactionManager mainTransactionManager(){
                logger.debug("mainTransactionManager init..");
                return new JpaTransactionManager(entityManagerFactoryBean.getObject());
        }
}
