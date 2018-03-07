package org.healtcare.hypermediadriven.microservices.patient.business.services;

import java.util.List;

import org.healtcare.hypermediadriven.microservices.patient.converters.HealtConditionConverter;
import org.healtcare.hypermediadriven.microservices.patient.domain.HealtCondition;
import org.healtcare.hypermediadriven.microservices.patient.domain.persistence.HealtConditionRepository;
import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Service
public class HealtConditionBusinessServiceImpl implements IHealtConditionBusinessService {
	public static final Logger LOGGER = LoggerFactory.getLogger(HealtConditionBusinessServiceImpl.class);
	@Autowired
	private HealtConditionRepository healtConditionRepository;
	@Autowired
	private HealtConditionConverter healtConditionConverter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.healtcare.hypermediadriven.patient.business.services.
	 * IHealtConditionBusinessService#readHealtConditionByPatient(java.lang.
	 * String)
	 */
	@Override
	public HealtConditionDTO readHealtConditionByPatient(final String patientUUID) throws HypermediaGenericException {
		LOGGER.info(
				"####### - Started HealtConditionBusinessServiceImpl.readHealtConditionByPatient(String patientUUID) - #######");
		final HealtCondition entity = healtConditionRepository.findByPatients_PatientUUID(patientUUID);
		final HealtConditionDTO dto = healtConditionConverter.convert(entity);
		LOGGER.info(
				"####### - Stopped HealtConditionBusinessServiceImpl.readHealtConditionByPatient(String patientUUID) - #######");
		return dto;
	}

	@Override
	public List<HealtConditionDTO> readAllHealtConditions() throws HypermediaGenericException {
		return healtConditionConverter.convert(healtConditionRepository.findAll());
	}

}
