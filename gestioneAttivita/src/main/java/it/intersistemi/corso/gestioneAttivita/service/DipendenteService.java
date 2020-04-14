package it.intersistemi.corso.gestioneAttivita.service;

import it.intersistemi.corso.gestioneAttivita.model.DipendenteDto;

public interface DipendenteService extends CrudService<DipendenteDto, Integer> {

	Iterable<DipendenteDto> listaDipendentiAttivita(String idAttivita);

}
