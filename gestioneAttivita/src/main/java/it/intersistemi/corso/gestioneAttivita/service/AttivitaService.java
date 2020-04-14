package it.intersistemi.corso.gestioneAttivita.service;

import it.intersistemi.corso.gestioneAttivita.model.AttivitaDto;

public interface AttivitaService extends CrudService<AttivitaDto, String> {

	public Iterable<AttivitaDto> listaAttivitaDipendente(Integer matrDipendente);

	public void assegnaAttivitaDipendente(String idAttivita, Integer idMatricola);

	public void rimuoviAttivitaDipendente(String idAttivita, Integer idMatricola);

}
