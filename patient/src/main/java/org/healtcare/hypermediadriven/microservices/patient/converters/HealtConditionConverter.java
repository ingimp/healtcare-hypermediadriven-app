package org.healtcare.hypermediadriven.microservices.patient.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.healtcare.hypermediadriven.microservices.patient.domain.HealtCondition;
import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Service
public class HealtConditionConverter {

	@Autowired
	private ModelMapper mapper;

	public HealtConditionDTO convert(final HealtCondition entity) {
		HealtConditionDTO dto = mapper.map(entity, HealtConditionDTO.class);
		return dto;
	}

	public Optional<HealtConditionDTO> convert(final Optional<HealtCondition> entity) {
		HealtConditionDTO dto = mapper.map(entity.get(), HealtConditionDTO.class);
		return Optional.of(dto);
	}

	public Optional<HealtConditionDTO> convert(final Optional<HealtCondition> entity, final String patientUUID) {
		HealtConditionDTO dto = mapper.map(entity.get(), HealtConditionDTO.class);
		dto.setPatientUUID(patientUUID);
		return Optional.of(dto);
	}

	public List<HealtConditionDTO> convert(final List<HealtCondition> entities) {
		List<HealtConditionDTO> dtos = new ArrayList<>();
		for (HealtCondition entity : entities) {
			dtos.add(mapper.map(entity, HealtConditionDTO.class));
		}
		return dtos;
	}

	public List<HealtConditionDTO> convert(final List<HealtCondition> entityList, final String patientUUID) {
		List<HealtConditionDTO> dtos = new ArrayList<>();
		for (HealtCondition entity : entityList) {
			HealtConditionDTO dto = mapper.map(entity, HealtConditionDTO.class);
			dto.setPatientUUID(patientUUID);
			dtos.add(dto);
		}
		return dtos;
	}

	public HealtCondition convert(final HealtConditionDTO dto) {
		HealtCondition entity = mapper.map(dto, HealtCondition.class);
		return entity;
	}
}
