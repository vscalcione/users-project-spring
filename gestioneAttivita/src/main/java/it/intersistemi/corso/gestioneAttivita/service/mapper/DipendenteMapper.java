package it.intersistemi.corso.gestioneAttivita.service.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corso.gestioneAttivita.entity.Dipendente;
import it.intersistemi.corso.gestioneAttivita.model.DipendenteDto;

@Component
public class DipendenteMapper implements EntityDtoMapper<DipendenteDto, Dipendente> {

	@Override
	public void entityToDto(Dipendente e, DipendenteDto dto) {
		dto.setIdMatricola(e.getIdMatricola());
		dto.setNome(e.getNome());
		dto.setCognome(e.getCognome());

	}

	@Override
	public void dtoToEntity(DipendenteDto dto, Dipendente e) {
		e.setIdMatricola(dto.getIdMatricola());
		e.setNome(dto.getNome());
		e.setCognome(dto.getCognome());
	}

	@Override
	public DipendenteDto createDtoInstance() {
		return new DipendenteDto();
	}

	@Override
	public Dipendente createEntityInstance() {
		return new Dipendente();
	}

}
