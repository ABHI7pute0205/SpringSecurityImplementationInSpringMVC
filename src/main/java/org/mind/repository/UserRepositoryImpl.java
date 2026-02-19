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

	@Override
	public User findByUsername(String username) {
		String sql = "select * from users where username=?";

	    try {
	        return jdbcTemplate.queryForObject(sql,(rs,rowNum)->{
	                User u = new User();
	                u.setId(rs.getInt("id"));
	                u.setUsername(rs.getString("username"));
	                u.setPassword(rs.getString("password"));
	                u.setEmail(rs.getString("email"));
	                u.setContact(rs.getString("contact"));
	                return u;
	            },
	            username
	        );
	    } catch (Exception e) {
	        return null;
	    }
	}

	
	
}
