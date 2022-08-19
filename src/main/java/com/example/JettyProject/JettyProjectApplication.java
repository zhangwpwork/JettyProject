package com.example.JettyProject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class,
		DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@Slf4j
public class JettyProjectApplication {

	@Bean
	public DataSource secondDataSource(){
		DataSourceProperties dataSourceProperties = secondDataSourceProperties();
		log.info("数据源已经连接成功，url为：{}",dataSourceProperties.getUrl());
		log.info("数据源名称为为:{}",dataSourceProperties.getType());
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean
	@ConfigurationProperties("other.datasource")
	public DataSourceProperties secondDataSourceProperties(){
		return new DataSourceProperties();
	}

	@Bean
	@Resource
	public DataSourceTransactionManager secondDataSourceTransactionManager(DataSource secondDataSource){
		return new DataSourceTransactionManager(secondDataSource);
	}


	public static void main(String[] args) {
		SpringApplication.run(JettyProjectApplication.class, args);
	}



}
