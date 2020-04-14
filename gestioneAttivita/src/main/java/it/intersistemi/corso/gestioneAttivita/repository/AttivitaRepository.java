package it.intersistemi.corso.gestioneAttivita.repository;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.gestioneAttivita.entity.Attivita;

public interface AttivitaRepository extends CrudRepository<Attivita, String> {

	Iterable<Attivita> findByDipendentesIdMatricola(Integer idMatricola);
}
