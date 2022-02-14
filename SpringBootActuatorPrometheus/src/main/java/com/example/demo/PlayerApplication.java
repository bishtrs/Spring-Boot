package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerApplication.class, args);
    }
	
    @Bean
    public ApplicationRunner playerInitializer(PlayerService playerService) {
        return args -> {
        	playerService.create(new Player("leo", "Leonardo ", "Messi"));
        	playerService.create(new Player("cristi", "Cristiano", "Ronaldo"));
        	playerService.create(new Player("diego", "Diego", "Maradona"));
        };
    }
}    