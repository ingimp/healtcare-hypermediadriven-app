package org.healtcare.hypermediadriven.microservices.patient.assembler;

import org.healtcare.hypermediadriven.microservices.patient.api.controllers.AllergyController;
import org.healtcare.hypermediadriven.microservices.patient.dto.AllergyDTO;
import org.healtcare.hypermediadriven.microservices.patient.resources.AllergyResource;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Service
public class AllergyResourceAssembler
		extends EmbeddableResourceAssemblerSupport<AllergyDTO, AllergyResource, AllergyController> {

	public AllergyResourceAssembler(EntityLinks entityLinks, RelProvider relProvider) {
		super(entityLinks, relProvider, AllergyController.class, AllergyResource.class);
	}

	@Override
	protected AllergyResource instantiateResource(AllergyDTO entity) {
		return new AllergyResource(entity.getAllergyUUID(), entity.getAllergyName(), entity.getAllergyDescription());
	}

	private AllergyResource toBaseResources(AllergyDTO entity) {
		final AllergyResource resource = createResourceWithId(entity.getAllergyUUID(), entity);
		return resource;
	}

	@Override
	public AllergyResource toResource(AllergyDTO entity) {
		final AllergyResource resource = toBaseResources(entity);
		// Add links to available actions
		return resource;
	}

	public AllergyResource toResource(AllergyDTO entity, String self) {
		final AllergyResource resource = toBaseResources(entity);
		// Add links to available actions
		return resource;
	}

	@Override
	public Link linkToSingleResource(AllergyDTO entity) {
		return entityLinks.linkToSingleResource(AllergyResource.class, entity.getAllergyUUID());
	}

	public AllergyResource toDetailedResource(final AllergyDTO dto) {
		// TODO: to implementation
		return null;
	}

}
