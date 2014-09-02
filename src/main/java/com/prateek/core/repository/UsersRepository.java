package com.prateek.core.repository;

import java.util.List;
import java.util.UUID;

import com.prateek.core.domain.User;

/**
 * For persistence
 */
public interface UsersRepository {
	  User save(User order);

	  void delete(UUID key);

	  User findById(UUID key);

	  List<User> findAll();
}
