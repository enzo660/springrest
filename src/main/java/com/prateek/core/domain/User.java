package com.prateek.core.domain;

import java.util.UUID;

/**
 * This is a Domain object that is part of the core of the application. 
 * A separate resource object exists for "user", that's exposed 
 * by the service
 *
 */
public class User {

	private final UUID key;
	private String name;
	private String city;
	
	public User(String name){
		this.key = UUID.randomUUID();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getKey() {
		return key;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
