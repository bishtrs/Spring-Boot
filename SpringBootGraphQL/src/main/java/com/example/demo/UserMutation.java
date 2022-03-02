package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User createUser(final int id, final String email, final String firstName, final String lastName) {
    	return userService.createUser(id, email, firstName, lastName);
	}
}
