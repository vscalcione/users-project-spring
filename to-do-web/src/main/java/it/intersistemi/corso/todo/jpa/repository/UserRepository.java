package it.intersistemi.corso.todo.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.todo.jpa.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

}
