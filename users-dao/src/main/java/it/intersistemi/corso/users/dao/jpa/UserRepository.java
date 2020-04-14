package it.intersistemi.corso.users.dao.jpa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.users.dao.jpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUserName(String userName);

	Iterable<User> findByGroupsGroupName(String groupName);
}
