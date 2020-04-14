package it.intersistemi.corso.users.dao.jdbc;

import java.util.List;

import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.model.UserDto;


public interface UserRepository extends CrudRepository<UserDto, Integer> {

	void addAuthority(String userName, String authority);

	void removeAuthority(String userName, String authority);

	List<AuthorityDto> listAuthorities(String userName);

}
