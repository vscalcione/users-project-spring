package it.intersistemi.corso.users.service.jpa.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corso.users.dao.jpa.entity.User;
import it.intersistemi.corso.users.model.UserDto;

@Component
public class UserMapper implements EntityDtoMapper<UserDto, User> {

	@Override
	public void dtoToEntity(UserDto dto, User e) {
		if(dto.getUserId() != null) {
			e.setUserId(dto.getUserId());
		}
		e.setUserName(dto.getUserName());
		e.setPassword(dto.getPassword());
		e.setEnabled(dto.isEnabled());
	}

	@Override
	public User createEntityInstance() {
		return new User();
	}

	@Override
	public void entityToDto(User e, UserDto dto) {
		dto.setUserId(e.getUserId());
		dto.setUserName(e.getUserName());
		dto.setPassword(e.getPassword());
		dto.setEnabled(e.getEnabled());
	}

	@Override
	public UserDto createDtoInstance() {
		return new UserDto();
	}

}
