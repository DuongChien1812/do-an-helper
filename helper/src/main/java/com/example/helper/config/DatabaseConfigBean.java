package com.example.helper.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DatabaseConfigBean {
	@Value("${dataSource.primary.driverclassname}")
	private String dsDriverClassName;
	@Value("${dataSource.primary.url}")
	private String dsUrl;
	@Value("${dataSource.primary.username}")
	private String username;
	@Value("${dataSource.primary.password}")
	private String password;
	
	@Bean(name = "dataSource")
	public DataSource primaryDataSource() throws Exception  {
		DataSourceBuilder builder=DataSourceBuilder.create();
		builder.driverClassName(dsDriverClassName);
		builder.url(dsUrl);
		builder.username(username);
		builder.password(password);
		return builder.build();
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
//	@Autowired
//	@Bean(name = "transactionManager")
//	@Qualifier("jdbc")
//	public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
//		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
//		txManager.setDataSource(dataSource);
//		return txManager;
//	}
}
