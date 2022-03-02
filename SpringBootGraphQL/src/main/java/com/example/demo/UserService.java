package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(final int id, final String email, final String firstName, final String lastName) {
		return userRepository.addUser(id, new User(id, "harry@hotmail.com", "Harry", "Potter"));
	}

	public List<User> getAllUsers(final int count) {
		return userRepository.findAll().stream().limit(count).collect(Collectors.toList());
	}

	public Optional<User> getUser(final Integer id) {
		return userRepository.findUser(id);
	}

}
