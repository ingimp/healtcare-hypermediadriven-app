package org.healtcare.hypermediadriven.microservices.patient.api.services;

import java.util.Optional;

import org.healtcare.hypermediadriven.microservices.patient.assembler.AllergyResourceAssembler;
import org.healtcare.hypermediadriven.microservices.patient.dto.AllergyDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;
import org.healtcare.hypermediadriven.microservices.patient.resources.AllergyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Service
public class AllergyApiServiceImpl implements IAllergyApiService<AllergyResource> {
	@Autowired
	private AllergyResourceAssembler assembler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.healtcare.hypermediadriven.patient.api.services.IAllergyApiService#
	 * buildResource(java.lang.Iterable)
	 */
	@Override
	public AllergyResource buildResource(AllergyDTO dto) throws HypermediaGenericException {
		return dto == null ? null : assembler.toResource(dto);
	}

	@Override
	public Optional<AllergyResource> buildResourceAsOptional(AllergyDTO dto) throws HypermediaGenericException {
		return dto == null ? Optional.ofNullable(null) : Optional.of(assembler.toResource(dto));
	}

	@Override
	public Resources<AllergyResource> buildResource(Iterable<AllergyDTO> dtos, String self)
			throws HypermediaGenericException {
		return assembler.toEmbeddedList(dtos, self);
	}

	@Override
	public AllergyResource buildResource(AllergyDTO dto, boolean detailed) throws HypermediaGenericException {
		return detailed ? assembler.toDetailedResource(dto) : assembler.toResource(dto);
	}

}
