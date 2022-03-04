package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConfiguration {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("localhost", 6379);
		JedisConnectionFactory jedisConnectionFactory =  new JedisConnectionFactory(configuration);
		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate() {
	    RedisTemplate<String, String> redisTemplate  = new RedisTemplate<>();
	    redisTemplate.setConnectionFactory(jedisConnectionFactory());
	    return redisTemplate;
	}

}
