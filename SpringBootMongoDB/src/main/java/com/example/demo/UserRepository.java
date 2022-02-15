package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;

@Component
public class UserRepository {

	private final MongoTemplate mongoTemplate;

	UserRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<User> findAll() {
		return mongoTemplate.findAll(User.class);
	}

	public User findById(long id) {
		return mongoTemplate.findById(id, User.class);
	}

	public User save(User user) {
		mongoTemplate.save(user);
		return user;
	}

	public UpdateResult update(String[] addresses) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(1));
		Update update = new Update();
		update.set("addresses", addresses);
		//return mongoTemplate.updateFirst(query, update, User.class);
		return mongoTemplate.upsert(query, update, User.class);

	}
	
	public void deleteAll() {
		mongoTemplate.findAllAndRemove(new Query(), User.class);
	}
	
	public void delete(int id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(1));
		mongoTemplate.remove(query, User.class);
	}
}
