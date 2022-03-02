package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingExample {
	
    private static Logger logger = LoggerFactory.getLogger(SpringBootLoggingExample.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoggingExample.class, args);
        logger.trace("Spring Boot app started");
        logger.warn("Spring Boot app started");
        logger.info("Spring Boot Logging Example");
        logger.debug("Spring Boot app starting");

    }
}  