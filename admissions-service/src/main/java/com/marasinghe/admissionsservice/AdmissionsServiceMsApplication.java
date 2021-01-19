package com.marasinghe.admissionsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class AdmissionsServiceMsApplication {
	
	@Bean
	@LoadBalanced
	//creating a bean (bean is a singleton object that unique to return and it prevents u from having to create instance of object every time  
	public RestTemplate getRestTemplate() {
		return new RestTemplate(); //this is a bean
	}

	public static void main(String[] args) {
		SpringApplication.run(AdmissionsServiceMsApplication.class, args);
	}

}
