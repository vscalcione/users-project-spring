package it.intersistemi.corso.gestioneAttivita.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.intersistemi.corso.gestioneAttivita.model.AttivitaDto;
import it.intersistemi.corso.gestioneAttivita.service.AttivitaService;
import it.intersistemi.corso.gestioneAttivita.service.DipendenteService;

@Controller
@RequestMapping("/attivita")
public class AttivitaController extends CrudController<AttivitaDto, String, AttivitaService> {

	@Autowired
	private DipendenteService dipendenteService;

	@Autowired
	public AttivitaController(AttivitaService service) {
		super(service);
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,
        		new CustomDateEditor(dateFormat, true));
    }

	@RequestMapping(value="/{id}/visualizzaDipendenti", method=RequestMethod.GET)
	public String showEditForm(@PathVariable("id") String idAttivita, Model model) {
		model.addAttribute("idAttivita", idAttivita);
		model.addAttribute("listaDipendenti", this.dipendenteService.listaDipendentiAttivita(idAttivita));
		return "attivita/listaDipendentiAttivita";
	}


	@Override
	protected String getEntityListModelName() {
		return "listaAttivita";
	}

	@Override
	protected String getEntityModelName() {
		return "attivita";
	}

	@Override
	protected String getListView() {
		return "attivita/listaAttivita";
	}

	@Override
	protected String getDetailsView() {
		return "attivita/dettaglioAttivita";
	}

	@Override
	protected String getFormView() {
		return "attivita/formAttivita";
	}

	@Override
	protected String getListUrl() {
		return "/attivita";
	}

}
