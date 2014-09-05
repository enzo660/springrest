package com.prateek.core.transformer;

import com.prateek.persistence.domain.User;
import com.prateek.rest.domain.UserResource;

/**
 * Transforms the back-end User (com.prateek.core.domain.User) object 
 * to the resource UserResource object (com.prateek.rest.domain.UserResource)
 *
 */
public class UserTransformer {
	
	public static UserResource transform(User user){
		UserResource userResource = new UserResource(user.getName(), user.getId());
		return userResource;
	}
	
}
