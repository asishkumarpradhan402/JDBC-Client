package com.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.main.model.User;
import com.main.request.model.UserRequest;

@Repository
public class UserDAO {

	private JdbcClient jdbcClient;

	public UserDAO(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}

	public int saveUser(UserRequest userRequest) {
		String selectQuery = "insert into users (name, email, status) values (:name, :email, :status)";
		return jdbcClient
				.sql(selectQuery)
				.param("name", userRequest.getName(), Types.VARCHAR)
				.param("email", userRequest.getEmail(), Types.VARCHAR)
				.param("status", userRequest.getStatus(), Types.INTEGER)
				.update();
	}
	
	public Optional<User> getUsersById(Integer id) {
		String selectQuery = "select * from users where id =:id";
		return jdbcClient.sql(selectQuery).param("id", id, Types.INTEGER).query(new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setStatus(rs.getInt("status"));
				return user;
			}
		}).optional();
	}
	
	public List<User> getAllUsers() {
		String selectQuery = "select * from users";
		return jdbcClient.sql(selectQuery).query(new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setStatus(rs.getInt("status"));
				return user;
			}
		}).list();
	}
}
