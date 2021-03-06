package it.intersistemi.corso.users.dao.jdbc.spring.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import it.intersistemi.corso.users.model.AuthorityDto;

public class AuthorityMapper implements RowMapper<AuthorityDto> {

	public AuthorityDto mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
		AuthorityDto entity = new AuthorityDto();
		// Estrarre i valori dal resultset
		entity.setAuthority(rs.getString("AUTHORITY"));
		entity.setDescription(rs.getString("DESCRIPTION"));
		return entity;
	}

}
