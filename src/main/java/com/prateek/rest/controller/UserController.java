package com.prateek.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
		List<com.prateek.rest.domain.User> userResources = new ArrayList<com.prateek.rest.domain.User>();
		for (User user : userService.getAllUsers()) {
			userResources.add(UserTransformer.transform(user));
		}
		return userResources;
	}

}
