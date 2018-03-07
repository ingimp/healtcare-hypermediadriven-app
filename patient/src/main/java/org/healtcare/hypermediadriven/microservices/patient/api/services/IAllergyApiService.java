package org.healtcare.hypermediadriven.microservices.patient.api.services;

import java.util.Optional;

import org.healtcare.hypermediadriven.microservices.patient.dto.AllergyDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;
import org.springframework.hateoas.Resources;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 * @param <AllergyResource>
 */
public interface IAllergyApiService<AllergyResource> {

	/**
	 * @param dto
	 * @return
	 * @throws HypermediaGenericException
	 */
	public AllergyResource buildResource(AllergyDTO dto) throws HypermediaGenericException;

	/**
	 * @param dtos
	 * @param self
	 * @return
	 * @throws HypermediaGenericException
	 */
	public Resources<AllergyResource> buildResource(Iterable<AllergyDTO> dtos, String self)
			throws HypermediaGenericException;

	/**
	 * @param dto
	 * @param detailed
	 * @return
	 * @throws HypermediaGenericException
	 */
	public AllergyResource buildResource(AllergyDTO dto, boolean detailed) throws HypermediaGenericException;

	/**
	 * @param dto
	 * @return
	 * @throws HypermediaGenericException
	 */
	public Optional<AllergyResource> buildResourceAsOptional(AllergyDTO dto) throws HypermediaGenericException;

	/**
	 * @param dtos
	 * @return
	 * @throws HypermediaGenericException
	 */
	public Resources<AllergyResource> buildResources(Iterable<AllergyDTO> dtos) throws HypermediaGenericException;
}
