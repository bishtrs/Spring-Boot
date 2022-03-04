package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
	
    @Bean
    public ApplicationRunner userInitializer(UserService userService) {
        return args -> {
            userService.create(new User("ironman", "Robert", "Downey", 45));
            userService.create(new User("batman", "Christian", "Bale", 36));
            userService.create(new User("superman", "Henry", "Cavill", 28));
        };
    }
}    