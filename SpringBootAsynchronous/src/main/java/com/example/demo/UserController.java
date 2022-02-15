package com.example.demo;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	// http://localhost:8080/users/ironman
	/*
	 * @GetMapping("/{id}") public User get(@PathVariable("id") String id) throws
	 * Exception { logger.info("getting user"); return userService.get(id).get(); }
	 */

	// http://localhost:8080/users/ironman
	@GetMapping("/{id}")
	public String getUser(@PathVariable("id") String id) throws Exception {
		logger.info("getting user & address");
		CompletableFuture<User> user = userService.get(id);
		CompletableFuture<Address> userAddress = userService.getAddress(id);
		CompletableFuture.allOf(user, userAddress).join();
		logger.info("returning user details");
		return user.get().toString() + "," + userAddress.get().toString();

	}

}
