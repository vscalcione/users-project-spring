package it.intersistemi.corso.todo.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.todo.jpa.entity.TodoList;

public interface TodoListRepository extends CrudRepository<TodoList, String> {

	List<TodoList> findByUserUsernameOrderByOrdineAttivita(String username);
}
