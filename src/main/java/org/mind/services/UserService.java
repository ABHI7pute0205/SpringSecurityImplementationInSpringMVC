package org.mind.services;

import org.mind.model.User;

public interface UserService {

	public int registerUser(User user);
	public User loginUser(String username, String password);
}
