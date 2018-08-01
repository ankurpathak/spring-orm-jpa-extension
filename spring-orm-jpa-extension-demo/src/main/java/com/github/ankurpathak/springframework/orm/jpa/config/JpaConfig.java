package com.github.ankurpathak.springframework.orm.jpa.config;

import com.github.ankurpathak.springframework.orm.jpa.hibernate.ExtendedHibernateJpaDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Created by ankur on 14-08-2016.
 */
@Configuration
public class JpaConfig {


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JdbcTemplate jdbcTemplate){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(jdbcTemplate.getDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.github.ankurpathak.springframework.orm.jpa.domain.model");
        entityManagerFactoryBean.setPersistenceUnitName("jpaPU");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter(){{
            setDatabase(Database.H2);
        }});


        entityManagerFactoryBean.setJpaDialect(new ExtendedHibernateJpaDialect(jdbcTemplate.getExceptionTranslator()));


        //entityManagerFactoryBean.setSqlExceptionTranslator(jdbcTemplate.getExceptionTranslator());
        return entityManagerFactoryBean;
    }








}
