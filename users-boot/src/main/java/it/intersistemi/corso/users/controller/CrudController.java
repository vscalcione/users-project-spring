package it.intersistemi.corso.users.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.intersistemi.corso.users.service.CrudService;

public abstract class CrudController<DTO, PK, S extends CrudService<DTO, PK>> {

	protected S service;

	public CrudController(S service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String showlist(Model model) {
		Iterable<DTO> entityList = this.service.findAll();
		model.addAttribute(this.getEntityListModelName(), entityList);
		return this.getListView();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showDetails(@PathVariable("id") PK id, Model model) {
		DTO entity = this.service.findById(id);
		model.addAttribute(this.getEntityModelName(), entity);
		return this.getDetailsView();
	}


	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String showNewForm() {
		return this.getFormView();
	}

	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String saveNewEntity(DTO dto) {
		this.service.insert(dto);
		return "redirect:"+this.getListUrl();
	}

	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String showEditForm(@PathVariable("id") PK id, Model model) {
		DTO dto = this.service.findById(id);
		model.addAttribute(this.getEntityModelName(), dto);
		this.onShowEditForm(id, dto, model);
		return this.getFormView();
	}

	protected void onShowEditForm(PK id, DTO dto, Model model) {

	}

	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String saveEntity(@PathVariable("id") PK id, DTO dto, Model model) {
		this.service.update(id, dto);
		return "redirect:"+this.getListUrl();
	}

	@RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
	public String deleteEntity(@PathVariable("id") PK id, Model model) {
		this.service.deleteById(id);
		return "redirect:"+this.getListUrl();
	}

	protected abstract String getEntityListModelName();

	protected abstract String getEntityModelName();

	protected abstract String getListView();

	protected abstract String getDetailsView();

	protected abstract String getFormView();

	protected abstract String getListUrl();

}
