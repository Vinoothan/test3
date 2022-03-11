package com.vinu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/ApiCheck/Service1/")
public class RestControllers {

	@Autowired(required = true)
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/Service1_API_1", method = RequestMethod.GET)
	public String service1Method() {
		System.out.println("inside Service1_API_1 Method...........");
		return "Returned from Service1_API_1";
	}
	

	@RequestMapping(value = "/Service2_API_1", method = RequestMethod.GET)
	public String callToService2Method() {
		System.out.println("inside Service2_API_1 Method...........");
//		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9091/ApiCheck/Service2/Service2_API_1";			
		return restTemplate.getForObject(url, String.class);
	}

	
	@RequestMapping(value = "/Service2_API_2", method = RequestMethod.GET)
	public String callToService2Api2Method() {
		System.out.println("inside callToService2Api2 Method...........");
		String url = "http://localhost:9091/ApiCheck/Service2/Service2_API_2";			
		return restTemplate.getForObject(url, String.class);
	}
}
