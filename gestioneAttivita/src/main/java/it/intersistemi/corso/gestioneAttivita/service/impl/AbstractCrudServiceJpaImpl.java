package it.intersistemi.corso.gestioneAttivita.service.impl;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corso.gestioneAttivita.service.CrudService;
import it.intersistemi.corso.gestioneAttivita.service.mapper.EntityDtoMapper;

public abstract class AbstractCrudServiceJpaImpl<E, PK, DTO, R extends CrudRepository<E, PK>, M extends EntityDtoMapper<DTO, E>>
	implements CrudService<DTO, PK> {

	protected R repository;

	protected M mapper;

	protected AbstractCrudServiceJpaImpl(R repository, M mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Transactional
	public Iterable<DTO> findAll() {
		return this.mapper.entityToDto(repository.findAll());
	}

	@Override
	public long countAll() {
		return repository.count();
	}

	@Transactional
	public DTO findById(PK id) {
		Optional<E> e = repository.findById(id);
		if(e.isPresent()) {
			return mapper.entityToDto(e.get());
		}
		return null;
	}

	@Transactional
	public PK insert(DTO dto) {
		E entity = this.mapper.dtoToEntity(dto);
		return this.getPK(repository.save(entity));
	}

	@Transactional
	public int update(PK id, DTO dto) {
		Optional<E> optE = this.repository.findById(id);
		if(optE.isPresent()) {
			E e = optE.get();
			this.mapper.dtoToEntity(dto, e);
			return 1;
		}
		return 0;
	}

	@Transactional
	public int deleteById(PK id) {
		Optional<E> optE = this.repository.findById(id);
		if(optE.isPresent()) {
			repository.deleteById(id);
			return 1;
		}
		return 0;
	}

	protected abstract PK getPK(E save);

}
