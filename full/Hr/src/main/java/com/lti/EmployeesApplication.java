package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import com.netflix.niws.client.http.RestClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class EmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}
	
	
	
	
	
	
	
}
/*
 * private ClientHttpRequestFactory clientHttpRequestFactory() {
 * HttpComponentsClientHttpRequestFactory factory= new
 * HttpComponentsClientHttpRequestFactory(); factory.setReadTimeout(20000);
 * factory.setConnectTimeout(20000);
 * 
 * return factory;
 * 
 * }
 * 
 * }
 */