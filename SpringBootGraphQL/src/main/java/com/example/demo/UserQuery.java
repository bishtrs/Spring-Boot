package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public List<User> getUsers(final int count) {
        return this.userService.getAllUsers(count);
    }

    public Optional<User> getUser(final Integer id) {
        return this.userService.getUser(id);
    }
}
