package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder().baseUrl("https://fakestoreapi.com/").build();
		return webClient;
	}
}