package it.intersistemi.corso.todo.service.mapper;

import it.intersistemi.corso.todo.jpa.entity.TodoList;
import it.intersistemi.corso.todo.model.TodoDTO;

public class TodoMapper implements EntityToDtoMapper<TodoDTO,TodoList>{

	@Override
	public void entityToDto(TodoList e, TodoDTO dto) {
		dto.setDescrizione(e.getDescrizione());
		dto.setIdAttivita(e.getIdAttivita());
		dto.setOrdineAttivita(e.getOrdineAttivita());
	}

	@Override
	public void dtoToEntity(TodoDTO dto, TodoList e) {
		e.setDescrizione(dto.getDescrizione());
		e.setIdAttivita(dto.getIdAttivita());
		e.setOrdineAttivita(dto.getOrdineAttivita());
	}

	@Override
	public TodoDTO createDtoInstance() {
		return new TodoDTO();
	}

	@Override
	public TodoList createEntityInstance() {
		return new TodoList();
	}



}
