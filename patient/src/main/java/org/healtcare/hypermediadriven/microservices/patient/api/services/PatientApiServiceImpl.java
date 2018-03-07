package org.healtcare.hypermediadriven.microservices.patient.api.services;

import java.util.Optional;

import org.healtcare.hypermediadriven.microservices.patient.assembler.PatientResourceAssembler;
import org.healtcare.hypermediadriven.microservices.patient.dto.PatientDTO;
import org.healtcare.hypermediadriven.microservices.patient.resources.PatientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Service
public class PatientApiServiceImpl implements IPatientApiService<PatientResource> {
	@Autowired
	private PatientResourceAssembler assembler;

	@Override
	public Resources<PatientResource> buildResources(Iterable<PatientDTO> dtos) {
		return dtos == null ? null : assembler.toEmbeddedList(dtos);

	}

	@Override
	public PatientResource buildResource(final PatientDTO dto, final boolean detailed) {
		return dto == null ? null : (detailed ? assembler.toDetailedResource(dto) : assembler.toResource(dto));

	}

	@Override
	public Optional<PatientResource> buildResourceAsOptional(final PatientDTO dto, final boolean detailed) {
		return dto == null ? Optional.ofNullable(null)
				: (detailed ? Optional.of(assembler.toDetailedResource(dto)) : Optional.of(assembler.toResource(dto)));

	}
}
