package org.healtcare.hypermediadriven.microservices.patient.api.services;

import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;
import org.springframework.hateoas.Resources;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 * @param <HealtConditionResource>
 */
public interface IHealtConditionApiService<HealtConditionResource> {

	/**
	 * @param dtos
	 * @return
	 * @throws HypermediaGenericException
	 */
	public Resources<HealtConditionResource> buildResource(Iterable<HealtConditionDTO> dtos)
			throws HypermediaGenericException;

	/**
	 * @param dto
	 * @param self
	 * @return
	 * @throws HypermediaGenericException
	 */
	public HealtConditionResource buildResource(HealtConditionDTO dto, String self) throws HypermediaGenericException;

	/**
	 * @param dto
	 * @param detailed
	 * @return
	 * @throws HypermediaGenericException
	 */
	public HealtConditionResource buildResource(HealtConditionDTO dto, boolean detailed)
			throws HypermediaGenericException;
}
