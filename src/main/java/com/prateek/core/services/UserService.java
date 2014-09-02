package com.prateek.core.services;

import java.util.List;
import java.util.UUID;

import com.prateek.core.domain.User;
import com.prateek.core.repository.UsersRepository;

/**
 * Calls the back-end code and does additional processing (eg. eventing, etc.)
 * if required
 * 
 * Can be modified to accept/return events
 *
 */
public class UserService {

	private final UsersRepository usersRepository;
	
	public UserService(final UsersRepository usersRepository){
		this.usersRepository = usersRepository;
	}
	
	public User saveUser(User user){
		return usersRepository.save(user);
	}
	
	public void deleteUser(UUID key){
		usersRepository.delete(key);
	}
	
	public User findByUserKey(UUID key){
		return usersRepository.findById(key);
	}
	
	public List<User> getAllUsers(){
		return usersRepository.findAll();
	}
	
}
