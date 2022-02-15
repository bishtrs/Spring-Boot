package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	private Map<String, User> users = new HashMap<>();

	public User get(String id) {
		logger.info("getting user");
		if (!users.containsKey(id)) {
			throw new UserNotFoundException();
		}
		return users.get(id);
	}

	public void create(User user) {
		users.put(user.getId(), user);
	}
}