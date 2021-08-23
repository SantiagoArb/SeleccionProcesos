package com.devco.seleccionprocesos.configuration;

import com.devco.seleccionprocesos.configuration.domain.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfig {
//    @Bean
//    public DataSource postgresDataSource(DataSourceProperties properties){
//
//        String url = String.format("jdbc:postgresql://%s:%s/%s", properties.getHost(), properties.getPort(), properties.getDb());
//        DataSourceBuilder config = DataSourceBuilder.create();
//        config.url(url);
//        config.username(properties.getUsername());
//        config.password(properties.getPassword());
//        config.driverClassName(properties.getDriverClassName());
//        return config.build();
  // }
}
