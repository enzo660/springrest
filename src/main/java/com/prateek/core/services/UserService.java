package com.prateek.core.services;

import java.util.List;

import com.prateek.persistence.domain.User;

/**
 * Calls the back-end code and does additional processing (eg. eventing, etc.)
 * if required
 * 
 * Can be modified to accept/return events
 *
 */
public interface UserService {
	
	//public User saveUser(User user);
	
	public void deleteUser(String id);
	
	public User findById(String id);
	
	public List<User> getAllUsers();
	
}
