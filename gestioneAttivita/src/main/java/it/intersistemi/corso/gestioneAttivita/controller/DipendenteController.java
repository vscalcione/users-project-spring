package it.intersistemi.corso.gestioneAttivita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.intersistemi.corso.gestioneAttivita.model.AttivitaDto;
import it.intersistemi.corso.gestioneAttivita.model.DipendenteDto;
import it.intersistemi.corso.gestioneAttivita.service.AttivitaService;
import it.intersistemi.corso.gestioneAttivita.service.DipendenteService;

@Controller
@RequestMapping("/dipendente")
public class DipendenteController extends CrudController<DipendenteDto, Integer, DipendenteService>{

	@Autowired
	private AttivitaService attivitaService;

	@Autowired
	public DipendenteController(DipendenteService service) {
		super(service);
	}

	@RequestMapping(value="/{id}/assegnaAttivita", method=RequestMethod.GET)
	public String showAssegnaAttivita(@PathVariable("id") Integer idMatricola, Model model) {
		DipendenteDto dto = this.service.findById(idMatricola);

		model.addAttribute(this.getEntityModelName(), dto);
		model.addAttribute("idMatricola", idMatricola);
		model.addAttribute("listaAttivitaDipendente", attivitaService.listaAttivitaDipendente(idMatricola));
		Iterable<AttivitaDto> listaAttivita = attivitaService.findAll();
		model.addAttribute("listaAttivita", listaAttivita);
		return "dipendente/assegnaAttivita";
	}

	@RequestMapping(value="/{id}/assegnaAttivita", method=RequestMethod.POST)
	public String saveAssegnaAttivita(@PathVariable("id") Integer idMatricola,
			@RequestParam(value="idAttivita", required=true) String idAttivita,
			Model model) {
		this.attivitaService.assegnaAttivitaDipendente(idAttivita, idMatricola);
		return "redirect:/dipendente/"+idMatricola+"/assegnaAttivita";
	}

	@RequestMapping(value="/{idMatricola}/rimuoviAttivita", method=RequestMethod.GET)
	public String rimuoviAttivita(@PathVariable("idMatricola") Integer idMatricola,
			@RequestParam(value="idAttivita", required=true) String idAttivita,
			Model model) {
		this.attivitaService.rimuoviAttivitaDipendente(idAttivita, idMatricola);
		return "redirect:/dipendente/"+idMatricola+"/assegnaAttivita";
	}

	@Override
	protected String getEntityListModelName() {
		return "listaDipendenti";
	}

	@Override
	protected String getEntityModelName() {
		return "dipendente";
	}

	@Override
	protected String getListView() {
		return "dipendente/listaDipendenti";
	}

	@Override
	protected String getDetailsView() {
		return "dipendente/dettaglioDipendente";
	}

	@Override
	protected String getFormView() {
		return "dipendente/formDipendente";
	}

	@Override
	protected String getListUrl() {
		return "/dipendente";
	}

}
