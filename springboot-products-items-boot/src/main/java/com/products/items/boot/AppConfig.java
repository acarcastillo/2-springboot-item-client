package com.products.items.boot;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean("restClient")
	@LoadBalanced
	public RestTemplate resgistryRestTemplate() {
		return new RestTemplate();
	}

}
