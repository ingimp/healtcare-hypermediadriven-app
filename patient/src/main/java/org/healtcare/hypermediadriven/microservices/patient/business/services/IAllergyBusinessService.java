package org.healtcare.hypermediadriven.microservices.patient.business.services;

import java.util.List;

import org.healtcare.hypermediadriven.microservices.patient.dto.AllergyDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
public interface IAllergyBusinessService {

	/**
	 * @return
	 * @throws HypermediaGenericException
	 */
	public List<AllergyDTO> readAllAllergies() throws HypermediaGenericException;

	/**
	 * @param patientUUID
	 * @return
	 * @throws HypermediaGenericException
	 */
	public List<AllergyDTO> readAllergiesByPatient(String patientUUID) throws HypermediaGenericException;

	/**
	 * @param allergyUUID
	 * @return
	 * @throws HypermediaGenericException
	 */
	public AllergyDTO readAllergy(String allergyUUID) throws HypermediaGenericException;

}
