package com.prateek.rest.domain;


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
public class UserResource {


	private final String id;
	private String name;
	
	public UserResource(String name, String id){
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}


	
}
