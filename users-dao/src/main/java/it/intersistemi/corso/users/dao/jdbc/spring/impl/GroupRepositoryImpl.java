package it.intersistemi.corso.users.dao.jdbc.spring.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.intersistemi.corso.users.dao.jdbc.spring.mapper.AuthorityMapper;
import it.intersistemi.corso.users.dao.jdbc.spring.mapper.GroupMapper;
import it.intersistemi.corso.users.dao.jdbc.spring.mapper.UserMapper;
import it.intersistemi.corso.users.dao.jdbc.GroupRepository;
import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.model.GroupDto;
import it.intersistemi.corso.users.model.UserDto;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GroupRepositoryImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Iterable<GroupDto> findAll() {
		return this.jdbcTemplate.query(
				"SELECT * FROM GROUPS",
				new GroupMapper());
	}

	@Override
	public GroupDto findById(String id) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM GROUPS WHERE GROUP_NAME = ?",
				new GroupMapper(),
				id);
	}

	@Override
	public String insert(GroupDto entity) {
		this.jdbcTemplate.update(
				"INSERT INTO GROUPS (GROUP_NAME, DESCRIPTION) VALUES (?, ?)",
				entity.getGroupName(),
				entity.getDescription());
		return entity.getGroupName();
	}

	@Override
	public int update(String id, GroupDto entity) {
		return this.jdbcTemplate.update(
				"UPDATE GROUPS SET GROUP_NAME = ?, DESCRIPTION = ? WHERE GROUP_NAME = ?",
				entity.getGroupName(),
				entity.getDescription(),
				id);
	}

	@Override
	public int deleteById(String id) {
		return this.jdbcTemplate.update(
				"DELETE GROUPS WHERE GROUP_NAME = ?",
				id);
	}

	// GROUP_AUTHORITIES

	@Override
	public void addAuthority(String groupName, String authority) {
		this.jdbcTemplate.update("INSERT INTO GROUP_AUTHORITIES (GROUP_NAME, AUTHORITY) VALUES (?, ?)",
				groupName,
				authority);
	}

	@Override
	public void removeAuthority(String groupName, String authority) {
		this.jdbcTemplate.update("DELETE GROUP_AUTHORITIES WHERE GROUP_NAME = ? AND AUTHORITY = ?",
				groupName,
				authority);
	}

	@Override
	public List<AuthorityDto> listAuthorities(String groupName) {
		return this.jdbcTemplate.query("SELECT a.*" +
				" FROM AUTHORITIES a" +
				" JOIN GROUP_AUTHORITIES ga ON ga.AUTHORITY = a.AUTHORITY" +
				" WHERE ga.GROUP_NAME = ?",
				new AuthorityMapper(),
				groupName);
	}

	// GROUP_MEMBERS

	@Override
	public void addUser(String groupName, String username) {
		this.jdbcTemplate.update("INSERT INTO GROUP_MEMBERS (USER_NAME, GROUP_NAME) VALUES (?, ?)",
				username,
				groupName);
	}

	@Override
	public void removeUser(String groupName, String username) {
		this.jdbcTemplate.update("DELETE GROUP_MEMBERS WHERE USER_NAME = ? AND GROUP_NAME = ?",
				username,
				groupName);
	}

	@Override
	public List<UserDto> listUsers(String groupName) {
		return this.jdbcTemplate.query("SELECT u.*" +
				" FROM USERS u" +
				" JOIN GROUP_MEMBERS gm ON gm.USER_NAME = u.USER_NAME" +
				" WHERE gm.GROUP_NAME = ?",
				new UserMapper(),
				groupName);
	}

}
