package org.healtcare.hypermediadriven.microservices.patient.api.services;

import org.healtcare.hypermediadriven.microservices.patient.assembler.HealtConditionAssembler;
import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;
import org.healtcare.hypermediadriven.microservices.patient.resources.HealtConditionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Service
public class HealtConditionApiServiceImpl implements IHealtConditionApiService<HealtConditionResource> {
	@Autowired
	HealtConditionAssembler assembler;

	@Override
	public Resources<HealtConditionResource> buildResource(Iterable<HealtConditionDTO> dtos)
			throws HypermediaGenericException {
		return assembler.toEmbeddedList(dtos);
	}

	@Override
	public HealtConditionResource buildResource(HealtConditionDTO dto, String self) throws HypermediaGenericException {
		return assembler.toEmbedded(dto, self);
	}

	@Override
	public HealtConditionResource buildResource(HealtConditionDTO dto, boolean detailed)
			throws HypermediaGenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resources<HealtConditionResource> buildResources(Iterable<HealtConditionDTO> dtos) {
		return dtos == null ? null : assembler.toEmbeddedList(dtos);

	}

}
