package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	private Map<String, User> users = new HashMap<>();
	private Map<String, Address> addresses = new HashMap<>();

	@Async
	public CompletableFuture<User> get(String id) throws Exception {
	//public User get(String id) throws InterruptedException, ExecutionException {
		logger.info("getting user");
			Thread.sleep(2000);
		return CompletableFuture.completedFuture(users.get(id));
		//return users.get(id);
	}
	
	@Async
	public CompletableFuture<Address> getAddress(String id) throws Exception {
		logger.info("getting user address");
			Thread.sleep(2000);
		return CompletableFuture.completedFuture(addresses.get(id));
	}

	public void create(User user) {
		users.put(user.getId(), user);
	}
	
	public void createAddress(Address address) {
		addresses.put(address.getId(), address);
	}
}