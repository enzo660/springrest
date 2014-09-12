package com.prateek.core.transformer;

import com.prateek.persistence.domain.User;

/**
 * Transforms the back-end User (com.prateek.core.domain.User) object 
 * to the REST-exposed User object (com.prateek.rest.domain.User)
 *
 */
public class UserTransformer {
	
	public static com.prateek.rest.domain.User transform(User user){
		com.prateek.rest.domain.User result = new com.prateek.rest.domain.User(user.getName(), user.getId());
		return result;
	}
	
}
