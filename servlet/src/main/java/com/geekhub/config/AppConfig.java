package com.geekhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@ComponentScan(basePackages = "com.geekhub")
@Configuration
public class AppConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setName("homework 5.1")
                .setType(H2)
                .addScript("schema.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
