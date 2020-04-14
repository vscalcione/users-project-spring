package it.intersistemi.corso.users.service;

import java.util.List;

import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.model.UserDto;


public interface UserService extends CrudService<UserDto, Integer> {

	UserDto findByUserName(String userName);

	void addAuthority(String userName, String authority);

	void removeAuthority(String userName, String authority);

	List<AuthorityDto> listAuthorities(String userName);

}
