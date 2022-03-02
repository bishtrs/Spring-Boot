package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQLApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLApplication.class, args);
    }
	
    @Bean
    public ApplicationRunner userInitializer(UserRepository userRepository) {
        return args -> {
        	userRepository.addUser(1, new User(1, "harry@hotmail.com", "Harry", "Potter"));
        };
    }
    
}    

//http://localhost:8080/graphiql

/*query{
	  users(count: 2) {
	    id,
	    email,
	    firstName,
	    lastName
	  }
	}



mutation {
	  
createUser(id: 2, email: "sfdsf@sdfsdf", firstName: "XYZ", lastName: "sdfd") {
  id
}
}*/