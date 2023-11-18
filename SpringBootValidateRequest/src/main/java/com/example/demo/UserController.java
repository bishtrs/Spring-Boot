package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private List<User> users = new ArrayList<>();

	public UserController() {
		users.add(new User("John", Long.valueOf(5417543010l)));
	}

	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable("id") String id) {
		return users.stream().filter(user -> user.getName().equalsIgnoreCase(id)).findAny();
	}
	
	@PostMapping("/")
	public User addUser(@Valid @RequestBody User user) {
		users.add(user);
		return user;
	}

}
