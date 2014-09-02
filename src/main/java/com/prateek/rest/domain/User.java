package com.prateek.rest.domain;

import java.util.UUID;

/**
 * This is a Resource object, different from the domain object that 
 * is part of the core of the application.
 * The Resource object is exposed through the RESTful webservice
 *
 * The domain object in the core contains the "city" property which
 * does not exist in the resource object because it is not required 
 * to be returned by the web service 
 *
 */
public class User {


	private final UUID key;
	private String name;
	
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

	
}
