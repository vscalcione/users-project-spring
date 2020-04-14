package it.intersistemi.corso.users.dao.jdbc.spring.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import it.intersistemi.corso.users.dao.jdbc.spring.mapper.AuthorityMapper;
import it.intersistemi.corso.users.dao.jdbc.AuthorityRepository;
import it.intersistemi.corso.users.model.AuthorityDto;

@Repository
public class AuthorityRepositoryImpl implements AuthorityRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate parameterJdbcTemplate;

	@Autowired
	public AuthorityRepositoryImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Iterable<AuthorityDto> findAll() {
		return this.jdbcTemplate.query(
				"SELECT * FROM AUTHORITIES",
				new AuthorityMapper());
	}

	@Override
	public AuthorityDto findById(String id) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM AUTHORITIES WHERE AUTHORITY = ?",
				new AuthorityMapper(),
				id);
	}

	@Override
	public String insert(AuthorityDto entity) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
		parameterJdbcTemplate.update(
		"INSERT INTO AUTHORITIES (AUTHORITY, DESCRIPTION) VALUES (:authority, :description)",
		paramSource);
//		return this.jdbcTemplate.update(
//				"INSERT INTO AUTHORITIES (AUTHORITY, DESCRIPTION) VALUES (?, ?)",
//				entity.getAuthority(),
//				entity.getDescription());
		return entity.getAuthority();
	}

	@Override
	public int update(String id, AuthorityDto entity) {
		return this.jdbcTemplate.update(
				"UPDATE AUTHORITIES SET AUTHORITY = ?, DESCRIPTION = ? WHERE AUTHORITY = ?",
				entity.getAuthority(),
				entity.getDescription(),
				id);
	}

	@Override
	public int deleteById(String id) {
		return this.jdbcTemplate.update(
				"DELETE AUTHORITIES WHERE AUTHORITY = ?",
				id);
	}

}
