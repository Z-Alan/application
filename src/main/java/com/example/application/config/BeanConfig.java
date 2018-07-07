package com.example.application.config;

/*
 * Created by home
 * on 2018/7/7.
 */


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * BeanConfig.
 * 通过Java Config 创建dataSource和JdbcTemplate
 *
 * @author zhou
 **/
@Configuration
@EnableTransactionManagement
@PropertySource(value={"classpath:config/source.properties"})
public class BeanConfig {

    @Autowired
    private Environment environment;

    // destroyMethod = "close" 的作用是当数据库连接不使用的时候，就把该连接重新放到数据池中，方便下次使用调用。

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(environment.getProperty("source.driverClassName").trim());
        druidDataSource.setUrl(environment.getProperty("source.url").trim());
        druidDataSource.setUsername(environment.getProperty("source.username").trim());
        druidDataSource.setPassword(environment.getProperty("source.password").trim());
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate () {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }


}
