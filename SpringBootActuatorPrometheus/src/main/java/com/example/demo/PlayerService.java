package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	private static Logger logger = LoggerFactory.getLogger(PlayerService.class);
	private Map<String, Player> players = new HashMap<>();

	public Player get(String id) {
		logger.info("getting player");
		return players.get(id);
	}

	public void create(Player player) {
		players.put(player.getId(), player);
	}
}