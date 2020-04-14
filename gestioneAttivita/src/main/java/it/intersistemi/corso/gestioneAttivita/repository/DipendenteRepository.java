package it.intersistemi.corso.gestioneAttivita.repository;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.gestioneAttivita.entity.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Integer>{

	Iterable<Dipendente> findByAttivitasIdAttivita(String idAttivita);

}
