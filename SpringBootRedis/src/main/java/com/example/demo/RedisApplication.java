package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
	
    @Bean
    public ApplicationRunner userInitializer(UserRepository userRepository) {
        return args -> {
        	System.out.println("reading all items");
        	System.out.println(userRepository.getAllItems());
        	System.out.println("adding item");
        	userRepository.addUser("1", new User("harry@hotmail.com", "Harry", "Potter"));
        	System.out.println("reading item");
        	System.out.println(userRepository.getUser("1"));
        	userRepository.updateUser("1", new User("harry@gmail.com", "Harry", "Potter"));
        	System.out.println(userRepository.getUser("1"));
        };
    }
    
}    