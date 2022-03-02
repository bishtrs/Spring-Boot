package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository()
public class UserRepository {

	private Map<Integer, User> users = new HashMap<>();
	
	
	public Collection<User> findAll() {
		return users.values();
	}

	public Optional<User> findUser(Integer userId) {
		return Optional.ofNullable(users.get(userId));
	}

	public User addUser(int id, User user) {
		users.put(id, user);
		return user;
	}

	public void deleteItem(Integer id) {
		users.remove(id);
	}

	public void updateUser(Integer id, User user) {
		users.put(id, user);
	}
}