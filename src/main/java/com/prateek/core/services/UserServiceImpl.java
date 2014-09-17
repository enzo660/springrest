package com.prateek.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.persistence.domain.User;
import com.prateek.persistence.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersRepository usersRepository;
	
//	public User saveUser(User user){
//		return usersRepository.save(user);
//	}
	
	public void deleteUser(String id){
		usersRepository.delete(id);
	}
	
	public User findById(String name){
		return usersRepository.findById(name);
	}
	
	public List<User> getAllUsers(){
		return usersRepository.findAll();
	}
}
