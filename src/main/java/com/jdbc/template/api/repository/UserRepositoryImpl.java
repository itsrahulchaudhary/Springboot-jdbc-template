package com.jdbc.template.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.template.api.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private static final String INSERT_USER_QUERY = "INSERT INTO USER(id,firstName,lastName,email) values(?,?,?,?)";
	private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE USER SET firstName=? WHERE ID=?";
	private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE ID=?";
	private static final String DELETE_USER_BY_ID = "DELETE FROM USER WHERE ID=?";
	private static final String GET_USERS_QUERY = "SELECT * FROM USER";
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public User saveUser(User user) {
		jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
		return user;
	}

	@Override
	public User updateUser(User user) {
		jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getFirstName(), user.getId());
		return user;
	}

	@Override
	public User findUserById(int id) {
		 return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
	            return new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"));
	        },id);
	}

	@Override
	public String deleteUserById(int id) {
		jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "User got deleted with id " + id;
	}

	@Override
	public List<User> getAllUsers() {
		  return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
	            return new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"));
	        });
	}

}
