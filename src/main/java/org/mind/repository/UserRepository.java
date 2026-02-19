package org.mind.repository;

import org.mind.model.User;

public interface UserRepository {

	public int registerUser(User user);
	public User findByUsername(String username);

}
