package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private List<User> users = new ArrayList<>();

	public UserController() {
		users.add(new User("barry", "Barry", "Allen", 25));
		users.add(new User("thing", "Benjamin", "Grimm", 36));
		users.add(new User("ironman", "Tony", "Stark", 38));
	}

	// http://localhost:8080/users/api?id=ironman
	@GetMapping("/api/v1")
	public User getUser(@RequestParam("id") String id) {
		return users.stream().filter(user -> user.getId().equalsIgnoreCase(id)).findAny().orElse(null);
	}
	
	@GetMapping("/api/v2")
	public User getUser2(@RequestParam(name = "id") String foo) {
		return users.stream().filter(user -> user.getId().equalsIgnoreCase(foo)).findAny().orElse(null);
	}
	
	@GetMapping("/api/v3")
	public User getUser3(@RequestParam(required = false) String id) {
		return users.stream().filter(user -> user.getId().equalsIgnoreCase(id)).findAny().orElse(null);
	}
	
	@GetMapping("/api/v4")
	public User getUser4(@RequestParam Optional<String> id) {
		return users.stream().filter(user -> user.getId().equalsIgnoreCase(id.get())).findAny().orElse(null);
	}
	
	@GetMapping("/api/v5")
	public User getUser5(@RequestParam(defaultValue = "barry") String id) {
		return users.stream().filter(user -> user.getId().equalsIgnoreCase(id)).findAny().orElse(null);
	}
	
	//http://localhost:8080/users/api/v6?ids=ironman,thing
	@GetMapping("/api/v6")
	public List<User> getUser6(@RequestParam List<String> ids) {
		return users.stream().filter(user -> ids.contains(user.getId())).collect(Collectors.toList());
	}

}
