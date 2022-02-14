package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	private static Logger logger = LoggerFactory.getLogger(PlayerController.class);

	@GetMapping("/{id}")
	public Player get(@PathVariable("id") String id) throws Exception {
		logger.info("getting player");
		return playerService.get(id);
	}

}
