package com.explora.team.config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@ComponentScan("com.explora.team")
public class SpringJdbcConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
        dataSource.setUsername("system");
        dataSource.setPassword("bryan");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        jdbcTemplate.setFetchSize(20000);
        return jdbcTemplate;
    }

    @Bean
    DataSourceTransactionManager dataSourceTransactionManager() throws SQLException {
        System.out.println();
        return new DataSourceTransactionManager(dataSource());
    }

}
