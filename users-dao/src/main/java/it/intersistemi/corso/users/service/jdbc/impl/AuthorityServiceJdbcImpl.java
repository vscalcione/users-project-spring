package it.intersistemi.corso.users.service.jdbc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corso.users.dao.jdbc.AuthorityRepository;
import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.service.AuthorityService;

@Service
public class AuthorityServiceJdbcImpl
	extends AbstractCrudServiceJdbcImpl<AuthorityDto, String, AuthorityRepository>
	implements AuthorityService {

	@Autowired
	public AuthorityServiceJdbcImpl(AuthorityRepository repository) {
		super(repository);
	}

}
