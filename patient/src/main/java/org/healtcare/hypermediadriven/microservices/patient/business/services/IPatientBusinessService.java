package org.healtcare.hypermediadriven.microservices.patient.business.services;

import java.util.List;

import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 * @param <PatientDTO>
 */
public interface IPatientBusinessService<PatientDTO> {

	/**
	 * @return
	 * @throws HypermediaGenericException
	 */
	public List<PatientDTO> readAllPatients() throws HypermediaGenericException;

	/**
	 * @param uuid
	 * @return
	 * @throws HypermediaGenericException
	 */
	public PatientDTO readPatient(String uuid) throws HypermediaGenericException;

	/**
	 * @param uuid
	 * @param detailed
	 * @return
	 * @throws HypermediaGenericException
	 */
	public PatientDTO readPatient(String uuid, boolean detailed) throws HypermediaGenericException;

	/**
	 * @param entity
	 * @throws HypermediaGenericException
	 */
	public void createPatient(PatientDTO dto) throws HypermediaGenericException;

	/**
	 * @param dto
	 * @throws HypermediaGenericException
	 */
	public void updatePatient(PatientDTO dto) throws HypermediaGenericException;

	/**
	 * @param dto
	 * @throws HypermediaGenericException
	 */
	public void hospitalize(PatientDTO dto) throws HypermediaGenericException;

}
