package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	@GetMapping("/{id}")
	public User get(@PathVariable("id") String id) throws Exception {
		logger.info("getting user");
		return userService.get(id);
	}
	
	/*@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException() {
		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	}*/

}
