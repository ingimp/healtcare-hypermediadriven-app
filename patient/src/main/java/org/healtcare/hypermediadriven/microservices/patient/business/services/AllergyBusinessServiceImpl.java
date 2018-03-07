package org.healtcare.hypermediadriven.microservices.patient.business.services;

import java.util.List;

import org.healtcare.hypermediadriven.microservices.patient.converters.AllergyConverter;
import org.healtcare.hypermediadriven.microservices.patient.domain.persistence.AllergyRepository;
import org.healtcare.hypermediadriven.microservices.patient.dto.AllergyDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ldicesare
 *
 */
@Service
public class AllergyBusinessServiceImpl implements IAllergyBusinessService {
    public static final Logger LOGGER = LoggerFactory.getLogger(AllergyBusinessServiceImpl.class);
    @Autowired
    private AllergyRepository allergyRepository;
    @Autowired
    private AllergyConverter allergyConverter;

    /*
     * (non-Javadoc)
     * 
     * @see org.healtcare.hypermediadriven.patient.business.services.IAllergyBusinessService#readAllergiesByPatient(java.lang.String)
     */
    @Override
    public List<AllergyDTO> readAllergiesByPatient(final String patientUUID) throws HypermediaGenericException {
        LOGGER.info("####^^^^#### - The AllergyBusinessServiceImpl.readAllergiesByPatient(String patientUUID) service is running.");
        return allergyConverter.convert(allergyRepository.findByPatients_PatientUUID(patientUUID));

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.healtcare.hypermediadriven.patient.business.services.IAllergyBusinessService#readAllergy(java.lang.String)
     */
    @Override
    public AllergyDTO readAllergy(final String allergyUUID) {
        LOGGER.info("####^^^^#### - The AllergyBusinessServiceImpl.readAllergy(String allergyUUID) service is running.");
        return allergyConverter.convert(allergyRepository.findByAllergyUUID(allergyUUID));
    }

}
