package org.mind.services;

import org.mind.model.User;
import org.mind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public int registerUser(User user) {
		String encrypted = passwordEncoder.encode(user.getPassword());
		user.setPassword(encrypted);
		
		return userRepo.registerUser(user);
	}

}
