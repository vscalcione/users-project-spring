package it.intersistemi.corso.users.service.jpa.mapper;

import java.util.ArrayList;
import java.util.List;

public interface EntityDtoMapper<DTO, E> {

	default Iterable<DTO> entityToDto(Iterable<E> eList) {
		if(eList != null) {
			List<DTO> dtoList = new ArrayList<>();
			for(E e : eList) {
				dtoList.add(this.entityToDto(e));
			}
			return dtoList;
		}
		return null;
	}

	default DTO entityToDto(E e) {
		if(e != null) {
			DTO dto = this.createDtoInstance();
			this.entityToDto(e, dto);
			return dto;
		}
		return null;
	}

	default E dtoToEntity(DTO dto) {
		if(dto != null) {
			E e = this.createEntityInstance();
			this.dtoToEntity(dto, e);
			return e;
		}
		return null;
	}

	void entityToDto(E e, DTO dto);

	void dtoToEntity(DTO dto, E e);

	DTO createDtoInstance();

	E createEntityInstance();
}
