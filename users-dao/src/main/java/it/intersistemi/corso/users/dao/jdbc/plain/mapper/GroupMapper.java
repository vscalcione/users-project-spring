package it.intersistemi.corso.users.dao.jdbc.plain.mapper;

import java.sql.ResultSet;

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
