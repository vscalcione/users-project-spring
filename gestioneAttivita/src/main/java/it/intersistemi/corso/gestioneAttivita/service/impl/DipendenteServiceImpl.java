package it.intersistemi.corso.gestioneAttivita.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corso.gestioneAttivita.entity.Dipendente;
import it.intersistemi.corso.gestioneAttivita.model.DipendenteDto;
import it.intersistemi.corso.gestioneAttivita.repository.DipendenteRepository;
import it.intersistemi.corso.gestioneAttivita.service.DipendenteService;
import it.intersistemi.corso.gestioneAttivita.service.mapper.DipendenteMapper;

@Service
public class DipendenteServiceImpl
	extends AbstractCrudServiceJpaImpl<Dipendente, Integer, DipendenteDto, DipendenteRepository, DipendenteMapper>
	implements DipendenteService {

	@Autowired
	protected DipendenteServiceImpl(DipendenteRepository repository, DipendenteMapper mapper) {
		super(repository, mapper);
	}

	@Override
	protected Integer getPK(Dipendente entity) {
		return entity.getIdMatricola();
	}

	@Override
	public Iterable<DipendenteDto> listaDipendentiAttivita(String idAttivita) {
		return mapper.entityToDto(repository.findByAttivitasIdAttivita(idAttivita));
	}

}
