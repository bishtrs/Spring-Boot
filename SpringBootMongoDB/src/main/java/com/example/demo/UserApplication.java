package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);

	}

	public void run(String... args) {
		String[] addresses = new String[] {"address1", "address2"};
		System.out.println("users in db " + userRepository.findAll());
		System.out.println("deleting all users in db ");
		userRepository.deleteAll();
		System.out.println("users in db " + userRepository.findAll());
		System.out.println("adding users in db ");
		userRepository.save(new User(1, "john@hotmail.com"));
		userRepository.save(new User(2, "mike@gmail.com"));
		System.out.println("users in db " + userRepository.findAll());
		System.out.println("looking for user with user id 1 in db");
		System.out.println(userRepository.findById(1));
		System.out.println("updating user in db ");
		userRepository.update(addresses);
		System.out.println(userRepository.findById(1));
	}
}