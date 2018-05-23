package com.mkyong.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories("com.neurogen.data.dao")
public class MySqlConfig {

    @Bean(name = "dataSource")
    public static DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(com.mkyong.config.Properties.DB_DRIVER_CLASS);
        dataSource.setUrl(com.mkyong.config.Properties.DB_URL+"?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false");
        dataSource.setUsername(com.mkyong.config.Properties.DB_USER);
        dataSource.setPassword(com.mkyong.config.Properties.DB_PASSWORD);
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    @Qualifier("sessionFactoryBean")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(com.mkyong.config.Properties.ENTITY_MANAGER_PACKAGES_TO_SCAN);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", com.mkyong.config.Properties.HIBERNATE_DIALECT);
        hibernateProperties.put("hibernate.show_sql", com.mkyong.config.Properties.HIBERNATE_SHOW_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto", com.mkyong.config.Properties.HBM2DDL_AUTO);
        hibernateProperties.put("hibernate.enable_lazy_load_no_trans", true);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        final JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory());
//        return transactionManager;
//    }

    @Primary
    @Bean
    @Qualifier("entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.mkyong.entity");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }
}