package com.example.demo;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Collection<User> getAll();
    User create(User user);
    Optional<User> get(String id);
    void delete(String id);
}