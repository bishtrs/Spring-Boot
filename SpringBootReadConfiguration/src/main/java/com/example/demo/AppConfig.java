package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;
    
    // reads data into a string array
    @Value("${listOfTables}")
    private String[] tableValues;
        
    // reads data into a map    
    @Value("#{${valuesMap}}")
    private Map<String, Integer> valuesMap;
    
    // reads single value from key value pair
    @Value("#{${valuesMap}['John']}")
    private Integer value1;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
        
    public String[] getTableValues() {
        return tableValues;
    }

    public Map<String, Integer> getValuesMap() {
        return valuesMap;
    }

    public Integer getValue1() {
        return value1;
    }
	
}