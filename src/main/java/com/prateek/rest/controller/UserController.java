package com.prateek.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.prateek.core.services.UserService;
import com.prateek.core.transformer.UserTransformer;
import com.prateek.persistence.domain.User;

@Controller
@RequestMapping("/users")
public class UserController {

	private static Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<com.prateek.rest.domain.User> getAllUsers() {
		List<com.prateek.rest.domain.User> results = new ArrayList<com.prateek.rest.domain.User>();
		for (User user : userService.getAllUsers()) {
			results.add(UserTransformer.transform(user));
		}
		return results;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<com.prateek.rest.domain.User> viewUser(@PathVariable String id) {
		User user = userService.findById(id);
		if(user == null){
			return new ResponseEntity<com.prateek.rest.domain.User>(HttpStatus.NOT_FOUND);
		}
		com.prateek.rest.domain.User result = UserTransformer.transform(user);

		return new ResponseEntity<com.prateek.rest.domain.User>(result, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<com.prateek.rest.domain.User> deleteUser(@PathVariable String id) {
		
		User user = userService.findById(id);
		if(user == null){
			return new ResponseEntity<com.prateek.rest.domain.User>(HttpStatus.NOT_FOUND);
		}
		com.prateek.rest.domain.User result = UserTransformer.transform(user);
		
		//Deletion code
		userService.deleteUser(id);

		//Return the deleted user
		return new ResponseEntity<com.prateek.rest.domain.User>(result, HttpStatus.OK);
		
	}

}
