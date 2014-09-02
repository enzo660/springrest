package com.prateek.core.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.prateek.core.domain.User;

/**
 * In-memory repo for simplicity. Can replace this with DB
 *
 */
public class UsersMemoryRepository implements UsersRepository {

	private Map<UUID, User> usersMap;

	public UsersMemoryRepository(final Map<UUID, User> usersMap){
		this.usersMap = Collections.unmodifiableMap(usersMap);
	}

	@Override
	public synchronized User save(User user) {

		Map<UUID, User> modifiableUsers = new HashMap<UUID, User>(usersMap);
		modifiableUsers.put(user.getKey(), user);
		this.usersMap = Collections.unmodifiableMap(modifiableUsers);

		return user;
	}

	@Override
	public synchronized void delete(UUID key) {
		if (usersMap.containsKey(key)) {
			Map<UUID, User> modifiableUsers = new HashMap<UUID, User>(usersMap);
			modifiableUsers.remove(key);
			this.usersMap = Collections.unmodifiableMap(modifiableUsers);
		}
	}

	@Override
	public User findById(UUID key) {
		return usersMap.get(key);
	}

	@Override
	public List<User> findAll() {
		return Collections.unmodifiableList(new ArrayList<User>(usersMap.values())); 
	}

}
