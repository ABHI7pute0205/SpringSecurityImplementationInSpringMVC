package org.mind.repository;

import org.mind.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int registerUser(User user) {
		String sql =
		         "insert into users(id,username,password,email,contact) values('0',?,?,?,?)";

		        return jdbcTemplate.update(
		            sql,
		            user.getUsername(),
		            user.getPassword(),
		            user.getEmail(),
		            user.getContact()
		        );
	}

	
	
}
