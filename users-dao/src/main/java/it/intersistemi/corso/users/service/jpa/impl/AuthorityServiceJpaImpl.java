package it.intersistemi.corso.users.service.jpa.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corso.users.dao.jpa.AuthorityRepository;
import it.intersistemi.corso.users.dao.jpa.entity.Authority;
import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.service.AuthorityService;
import it.intersistemi.corso.users.service.jpa.mapper.AuthorityMapper;

@Service
public class AuthorityServiceJpaImpl
	extends AbstractCrudServiceJpaImpl<Authority, String, AuthorityDto, AuthorityRepository, AuthorityMapper>
	implements AuthorityService {

	@Autowired
	public AuthorityServiceJpaImpl(AuthorityRepository repository, AuthorityMapper mapper) {
		super(repository, mapper);
	}

	@Override
	protected String getPK(Authority e) {
		return e.getAuthority();
	}

}
