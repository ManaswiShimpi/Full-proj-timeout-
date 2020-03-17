package com.lti.demo.Controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class MyCallable implements Callable<String> {
@Autowired
RestTemplate restTemplate;

	@Override
	public String call() throws Exception {

		return restTemplate.getForObject("http://localhost:8089/admission/getAll",String.class);
	}
}
