package com.example.demo;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
    private final Map<String, User> users =  new ConcurrentHashMap<>();

    @Override
    public Collection<User>  getAll() {
        return users.values();
    }

    @Override
    public User create(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> get(String id) {
        return Optional.ofNullable(users.get(id));
    }
    
    @Override
    public void delete(String id) {
    	users.remove(id);
    }
	
}   