package com.example.demo;

import java.util.Collection;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public Collection<User> getAllUsers() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<User> get(@PathVariable("id") String id) {
		return userService.get(id);
	}

	@PostMapping()
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		userService.delete(id);
	}

}
