package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class AdmissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate(/*clientHttpRequestFactory()*/);
	}
	/*private ClientHttpRequestFactory clientHttpRequestFactory()
	{
	 HttpComponentsClientHttpRequestFactory factory= new
	  HttpComponentsClientHttpRequestFactory();
	 factory.setReadTimeout(20000);
	  factory.setConnectTimeout(20000);
	  
	  return factory;*/
	}
	

