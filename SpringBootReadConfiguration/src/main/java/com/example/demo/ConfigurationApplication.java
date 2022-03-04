package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConfigurationApplication {

    @Autowired
    private AppConfig appConfig;

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }

    @Bean
    public ApplicationRunner printDataBaseConfig() {
        return args -> {
            System.out.println(appConfig.getUsername());
            System.out.println(appConfig.getPassword());
            System.out.println(Arrays.toString(appConfig.getTableValues()));
            System.out.println(appConfig.getValuesMap());
            System.out.println(appConfig.getValue1());            
        };
    }

}	