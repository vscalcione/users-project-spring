package it.intersistemi.corso.users.dao.jdbc.spring.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import it.intersistemi.corso.users.model.GroupDto;

public class GroupMapper implements RowMapper<GroupDto> {

	public GroupDto mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
		GroupDto entity = new GroupDto();
		// Estrarre i valori dal resultset
		entity.setGroupName(rs.getString("GROUP_NAME"));
		entity.setDescription(rs.getString("DESCRIPTION"));
		return entity;
	}

}
