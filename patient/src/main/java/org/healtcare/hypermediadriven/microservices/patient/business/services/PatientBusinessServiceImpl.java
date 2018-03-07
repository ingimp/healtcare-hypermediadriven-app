package org.healtcare.hypermediadriven.microservices.patient.business.services;

import static org.healtcare.hypermediadriven.microservices.patient.handler.utils.ResourceHandlingUtils.entityOrNotFoundException;

import java.util.List;
import java.util.UUID;

import org.healtcare.hypermediadriven.microservices.patient.converters.PatientConverter;
import org.healtcare.hypermediadriven.microservices.patient.domain.Patient;
import org.healtcare.hypermediadriven.microservices.patient.domain.persistence.PatientRepository;
import org.healtcare.hypermediadriven.microservices.patient.dto.AllergyDTO;
import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.healtcare.hypermediadriven.microservices.patient.dto.PatientDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ldicesare
 *
 */
@Service
public class PatientBusinessServiceImpl implements IPatientBusinessService<PatientDTO> {
    public static final Logger LOGGER = LoggerFactory.getLogger(PatientBusinessServiceImpl.class);
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientConverter patientConverter;
    @Autowired
    private IAllergyBusinessService allergyBusinessService;
    @Autowired
    private IHealtConditionBusinessService healtConditionBusinessService;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = {
	    HypermediaGenericException.class })
    @Override
    public List<PatientDTO> readAllPatients() throws HypermediaGenericException {
	LOGGER.info("####### - Started PatientBusinessServiceImpl.readAllPatients() - #######");
	final List<Patient> patients = patientRepository.findAll();
	final List<PatientDTO> dtos = patientConverter.convert(patients);
	LOGGER.info("####### - Stopped PatientBusinessServiceImpl.readAllPatients() - #######");
	return dtos;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = {
	    HypermediaGenericException.class })
    @Override
    public PatientDTO readPatient(final String uuid) throws HypermediaGenericException {
	LOGGER.info("####### - Started PatientBusinessServiceImpl.readPatient(String uuid) - #######");
	final Patient patient = entityOrNotFoundException(patientRepository.findByPatientUUID(uuid));
	final PatientDTO dto = patientConverter.convert(patient);
	LOGGER.info("####### - Stopped PatientBusinessServiceImpl.readPatient(String uuid) - #######");
	return dto;

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.healtcare.hypermediadriven.patient.business.services.
     * IPatientBusinessService#readPatient(java.lang.String, boolean)
     */
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = {
	    HypermediaGenericException.class })
    @Override
    public PatientDTO readPatient(final String uuid, final boolean detailed) throws HypermediaGenericException {
	LOGGER.info(
		"####### - Started PatientBusinessServiceImpl.readPatient(String uuid, boolean detailed) - #######");
	final Patient patient = entityOrNotFoundException(patientRepository.findByPatientUUID(uuid));
	final PatientDTO patientDTO = patientConverter.convert(patient);
	// FIXME: NON necessario perchè modelmapper funziona con il lazy
	// Adds all the details to the patient
	if (detailed) {
	    final List<AllergyDTO> allergyDtos = allergyBusinessService.readAllergiesByPatient(uuid);
	    patientDTO.addAll(allergyDtos);
	    final HealtConditionDTO healtConditionDTO = healtConditionBusinessService.readHealtConditionByPatient(uuid);
	    patientDTO.setHealtCondition(healtConditionDTO);
	}
	LOGGER.info(
		"####### - Stopped PatientBusinessServiceImpl.readPatient(String uuid, boolean detailed) - #######");
	return patientDTO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.healtcare.hypermediadriven.patient.business.services.
     * IPatientBusinessService#createPatient(java.lang.Object)
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {
	    HypermediaGenericException.class })
    @Override
    public void createPatient(final PatientDTO dto) throws HypermediaGenericException {
	LOGGER.info("####### - Started PatientBusinessServiceImpl.createPatient(PatientDTO dto) - #######");
	final Patient patient = patientConverter.convert(dto).withPatientUUID(UUID.randomUUID().toString());
	patientRepository.save(patient);
	LOGGER.info("####### - Stopped PatientBusinessServiceImpl.createPatient(PatientDTO dto) - #######");

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {
	    HypermediaGenericException.class })
    @Override
    public void hospitalize(final PatientDTO dto) {
	Patient patient = entityOrNotFoundException(patientRepository.findByPatientUUID(dto.getPatientUUID()));
	patient.setHospitalized(dto.getHospitalized());
	patientRepository.save(patient);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {
	    HypermediaGenericException.class })
    @Override
    public void updatePatient(final PatientDTO dto) throws HypermediaGenericException {
	// Patient patient =
	// entityOrNotFoundException(patientRepository.findByPatientUUID(dto.getPatientUUID()));
	// patient.setHospitalized(dto.isHospitalized());
	// patientRepository.save(patientConverter.convert(dto));

    }

}
