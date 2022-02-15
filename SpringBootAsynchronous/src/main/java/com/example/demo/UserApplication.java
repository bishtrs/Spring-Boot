package com.example.demo;

import java.util.concurrent.Executor;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
    
    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(125);
        executor.setThreadNamePrefix("thread-exec");
        executor.initialize();
        return executor;
    }
	
    @Bean
    public ApplicationRunner userInitializer(UserService userService) {
        return args -> {
            userService.create(new User("ironman", "Robert", "Downey", 45));
            userService.create(new User("batman", "Christian", "Bale", 36));
            userService.create(new User("superman", "Henry", "Cavill", 28));
            userService.createAddress(new Address("ironman", "New York"));
            userService.createAddress(new Address("batman", "Amsterdam"));
            userService.createAddress(new Address("superman", "London"));
        };
    }
    
}    