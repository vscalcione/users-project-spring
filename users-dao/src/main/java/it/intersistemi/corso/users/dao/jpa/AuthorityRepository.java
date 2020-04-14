package it.intersistemi.corso.users.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.users.dao.jpa.entity.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, String> {

	Iterable<Authority> findByGroups_GroupName(String groupName);

	Iterable<Authority> findByUsers_UserName(String userName);

}
