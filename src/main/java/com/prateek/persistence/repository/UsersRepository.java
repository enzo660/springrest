package com.prateek.persistence.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prateek.persistence.domain.User;

/**
 * For persistence.
 * Spring creates an implementation of the Repository interface 
 */
public interface UsersRepository extends MongoRepository<User, String>{

	//No need to implement these methods. The implementation will be auto-wired

	//User save(User user);

	//void delete(UUID key);

	public User findByName(String name);

	List<User> findAll();
}
