package it.intersistemi.corso.users.service;

import java.util.List;

import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.model.GroupDto;
import it.intersistemi.corso.users.model.UserDto;


public interface GroupService extends CrudService<GroupDto, String> {

	void addAuthority(String groupName, String authority);

	void removeAuthority(String groupName, String authority);

	List<AuthorityDto> listAuthorities(String groupName);

	void addUser(String groupName, String username);

	void removeUser(String groupName, String username);

	List<UserDto> listUsers(String groupName);

}
