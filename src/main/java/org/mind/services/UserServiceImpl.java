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

	@Override
	public User loginUser(String username, String password) {
		
		User user = userRepo.findByUsername(username); 
		
		// matches method cha use karun user UI var ti input field madhe jo passwrod enter kar to 
		// to match method ne DB madhlya encrypted password sobat compaire houn login la allow karto
		if(user != null && passwordEncoder.matches(password, user.getPassword())) {
			return user;
		}
		
		return null;
	}

}
