package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository()
public class UserRepository {

	public static final String KEY = "USER";
	
	private HashOperations<String, String, User> hashOperations;
	
	@Autowired
	public UserRepository(RedisTemplate<String, String> redisTemplate) {
		hashOperations = redisTemplate.opsForHash();
	}
	
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}
	
	public Map<String, User> getAllItems() {
		return hashOperations.entries(KEY);
	}

	public User getUser(String itemId) {
		return hashOperations.get(KEY, itemId);
	}

	public void addUser(String id, User user) {
		hashOperations.put(KEY, id, user);
	}

	public void deleteItem(String id) {
		hashOperations.delete(KEY, id);
	}

	public void updateUser(String id, User user) {
		addUser(id, user);
	}
}