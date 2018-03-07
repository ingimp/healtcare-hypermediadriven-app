package org.healtcare.hypermediadriven.microservices.patient.assembler;

import static java.util.Arrays.asList;

import java.util.List;

import org.healtcare.hypermediadriven.microservices.patient.resources.AllergyResource;
import org.healtcare.hypermediadriven.microservices.patient.resources.HealtConditionResource;
import org.healtcare.hypermediadriven.microservices.patient.resources.IndexResource;
import org.healtcare.hypermediadriven.microservices.patient.resources.PatientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

@Service
public class IndexResourceAssembler {
	private final RelProvider relProvider;
	private final EntityLinks entityLinks;

	@Autowired
	public IndexResourceAssembler(RelProvider relProvider, EntityLinks entityLinks) {
		this.relProvider = relProvider;
		this.entityLinks = entityLinks;
	}

	public IndexResource buildIndex() {
		// Note this is unfortunately hand-written. If you add a new entity,
		// have to manually add a new link
		final List<Link> links = asList(
				entityLinks.linkToCollectionResource(PatientResource.class)
						.withRel(relProvider.getCollectionResourceRelFor(PatientResource.class)),
				entityLinks.linkToCollectionResource(AllergyResource.class)
						.withRel(relProvider.getCollectionResourceRelFor(AllergyResource.class)),
				entityLinks.linkToCollectionResource(HealtConditionResource.class)
						.withRel(relProvider.getCollectionResourceRelFor(HealtConditionResource.class)));
		final IndexResource resource = new IndexResource("patient-microservice-hateoas", "A sample HATEOAS API");
		resource.add(links);
		return resource;
	}
}
