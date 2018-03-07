package org.healtcare.hypermediadriven.microservices.patient.api.services;

import java.util.Optional;

import org.healtcare.hypermediadriven.microservices.patient.dto.PatientDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;
import org.springframework.hateoas.Resources;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 * @param <PatientResource>
 */
public interface IPatientApiService<PatientResource> {

	/**
	 * @param dtos
	 * @return
	 * @throws HypermediaGenericException
	 */
	public Resources<PatientResource> buildResources(Iterable<PatientDTO> dtos) throws HypermediaGenericException;

	/**
	 * @param dto
	 * @return
	 * @throws HypermediaGenericException
	 */
	public PatientResource buildResource(PatientDTO dto, boolean detailed) throws HypermediaGenericException;

	public Optional<PatientResource> buildResourceAsOptional(PatientDTO dto, boolean detailed)
			throws HypermediaGenericException;

}
