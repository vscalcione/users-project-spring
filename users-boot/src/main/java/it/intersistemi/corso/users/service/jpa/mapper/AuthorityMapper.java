package it.intersistemi.corso.users.service.jpa.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corso.users.dao.jpa.entity.Authority;
import it.intersistemi.corso.users.model.AuthorityDto;

@Component
public class AuthorityMapper implements EntityDtoMapper<AuthorityDto, Authority> {

	@Override
	public void dtoToEntity(AuthorityDto dto, Authority e) {
		e.setAuthority(dto.getAuthority());
		e.setDescription(dto.getDescription());
	}

	@Override
	public Authority createEntityInstance() {
		return new Authority();
	}

	@Override
	public void entityToDto(Authority e, AuthorityDto dto) {
		dto.setAuthority(e.getAuthority());
		dto.setDescription(e.getDescription());
	}

	@Override
	public AuthorityDto createDtoInstance() {
		return new AuthorityDto();
	}

}
