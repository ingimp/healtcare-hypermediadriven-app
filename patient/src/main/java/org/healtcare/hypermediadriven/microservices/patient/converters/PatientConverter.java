package org.healtcare.hypermediadriven.microservices.patient.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.healtcare.hypermediadriven.microservices.patient.domain.Patient;
import org.healtcare.hypermediadriven.microservices.patient.dto.PatientDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Component
public class PatientConverter {
	static final Logger LOGGER = LoggerFactory.getLogger(PatientConverter.class);
	@Autowired
	private ModelMapper mapper;

	/**
	 * @param entity
	 * @return
	 * @throws ParseException
	 */
	public PatientDTO convert(final Patient entity) throws ParseException {
		PatientDTO dto = mapper.map(entity, PatientDTO.class);
		return dto;
	}

	public PatientDTO convert(final Optional<Patient> entity) throws ParseException {
		PatientDTO dto = mapper.map(entity.get(), PatientDTO.class);
		return dto;
	}

	/**
	 * @param entities
	 * @return
	 * @throws ParseException
	 */
	public List<PatientDTO> convert(final List<Patient> entities) throws ParseException {
		List<PatientDTO> dtos = new ArrayList<>();
		for (Patient entity : entities) {
			dtos.add(mapper.map(entity, PatientDTO.class));
		}
		return dtos;
	}

	public Patient convert(final PatientDTO dto) throws ParseException {
		Patient entity = mapper.map(dto, Patient.class);
		return entity;
	}

}
