package it.intersistemi.corso.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.service.AuthorityService;

@Controller
@RequestMapping("/authorities")
public class AuthorityController extends CrudController<AuthorityDto, String, AuthorityService> {

	@Autowired
	public AuthorityController(AuthorityService repository) {
		super(repository);
	}

	@Override
	protected String getEntityListModelName() {
		return "authorityList";
	}

	@Override
	protected String getEntityModelName() {
		return "authority";
	}

	@Override
	protected String getListView() {
		return "authorities/authorityList";
	}

	@Override
	protected String getDetailsView() {
		return "authorities/authorityDetails";
	}

	@Override
	protected String getFormView() {
		return "authorities/authorityForm";
	}

	@Override
	protected String getListUrl() {
		return "/authorities";
	}

}
