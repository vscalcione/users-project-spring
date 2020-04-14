package it.intersistemi.corso.users.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.users.dao.jpa.entity.Group;

public interface GroupRepository extends CrudRepository<Group, String> {

}
