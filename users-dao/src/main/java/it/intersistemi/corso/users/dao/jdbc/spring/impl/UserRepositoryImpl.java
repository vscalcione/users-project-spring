package it.intersistemi.corso.users.dao.jdbc.spring.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import it.intersistemi.corso.users.dao.jdbc.UserRepository;
import it.intersistemi.corso.users.dao.jdbc.spring.mapper.AuthorityMapper;
import it.intersistemi.corso.users.dao.jdbc.spring.mapper.UserMapper;
import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.model.UserDto;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate parameterJdbcTemplate;

	@Autowired
	public UserRepositoryImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Iterable<UserDto> findAll() {
		return this.jdbcTemplate.query(
				"SELECT * FROM USERS",
				new UserMapper());
	}

	@Override
	public UserDto findById(Integer id) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM USERS WHERE USER_ID = ?",
				new UserMapper(),
				id);
	}

	@Override
	public Integer insert(UserDto entity) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
		this.parameterJdbcTemplate.update(
				"INSERT INTO USERS (USER_NAME, PASSWORD, ENABLED)"
					+ " VALUES (:userName, :password, :enabled)",
		paramSource, keyHolder);

		return keyHolder.getKey().intValue();
//		this.jdbcTemplate.update(
//				"INSERT INTO USERS (USER_NAME, PASSWORD, ENABLED) VALUES (?, ?, ?)",
//				keyHolder,
//				entity.getUserName(),
//				entity.getPassword(),
//				entity.isEnabled());
//		return entity.getUserId();
	}

	@Override
	public int update(Integer id, UserDto entity) {
		return this.jdbcTemplate.update(
				"UPDATE USERS SET USER_NAME = ?, PASSWORD = ?, ENABLED = ? WHERE USER_ID = ?",
				entity.getUserName(),
				entity.getPassword(),
				entity.isEnabled(),
				id);
	}

	@Override
	public int deleteById(Integer id) {
		return this.jdbcTemplate.update(
				"DELETE USERS WHERE USER_ID = ?",
				id);
	}

	// GROUP_AUTHORITIES

	@Override
	public void addAuthority(String userName, String authority) {
		this.jdbcTemplate.update("INSERT INTO USER_AUTHORITIES (USER_NAME, AUTHORITY) VALUES (?, ?)",
				userName,
				authority);
	}

	@Override
	public void removeAuthority(String userName, String authority) {
		this.jdbcTemplate.update("DELETE USER_AUTHORITIES WHERE USER_NAME = ? AND AUTHORITY = ?",
				userName,
				authority);
	}

	@Override
	public List<AuthorityDto> listAuthorities(String userName) {
		return this.jdbcTemplate.query("SELECT a.*" +
				" FROM AUTHORITIES a" +
				" JOIN USER_AUTHORITIES ua ON ua.AUTHORITY = a.AUTHORITY" +
				" WHERE ua.USER_NAME = ?",
				new AuthorityMapper(),
				userName);
	}

}
