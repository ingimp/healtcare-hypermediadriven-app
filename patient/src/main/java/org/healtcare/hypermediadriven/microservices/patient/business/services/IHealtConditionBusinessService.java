package org.healtcare.hypermediadriven.microservices.patient.business.services;

import java.util.List;

import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
public interface IHealtConditionBusinessService {

	public List<HealtConditionDTO> readAllHealtConditions() throws HypermediaGenericException;

	/**
	 * @param patientUUID
	 * @return
	 * @throws HypermediaGenericException
	 */
	public HealtConditionDTO readHealtConditionByPatient(String patientUUID) throws HypermediaGenericException;

}
