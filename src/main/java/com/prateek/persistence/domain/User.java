package com.prateek.persistence.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This is a Domain object that is part of the "persistence" layer of the application. 
 * A separate resource object exists for "user", that's exposed 
 * by the service
 *
 */
@Document(collection = "user")
public class User {

	@Id
	private String id;
	@Indexed
	private String name;
	private String city;
	
	public User(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
    public String toString() {
        return String.format(
                "User[id=%s, nme='%s', city='%s']",
                id, name, city);
    }
	
}
