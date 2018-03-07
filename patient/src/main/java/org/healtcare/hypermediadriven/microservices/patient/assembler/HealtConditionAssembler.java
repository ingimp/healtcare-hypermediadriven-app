package org.healtcare.hypermediadriven.microservices.patient.assembler;

import org.healtcare.hypermediadriven.microservices.patient.api.controllers.HealtConditionController;
import org.healtcare.hypermediadriven.microservices.patient.domain.HealtCondition;
import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.healtcare.hypermediadriven.microservices.patient.resources.HealtConditionResource;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

@Service
public class HealtConditionAssembler extends EmbeddableResourceAssemblerSupport<HealtConditionDTO, HealtConditionResource, HealtConditionController> {

    public HealtConditionAssembler(EntityLinks entityLinks, RelProvider relProvider) {
        super(entityLinks, relProvider, HealtConditionController.class, HealtConditionResource.class);
    }

    @Override
    protected HealtConditionResource instantiateResource(HealtConditionDTO entity) {
        return new HealtConditionResource(entity.getHealtConditionUUID(), entity.getHealtConditionName());
    }

    private HealtConditionResource toBaseResources(HealtConditionDTO entity) {
        final HealtConditionResource resource = createResourceWithId(entity.getHealtConditionUUID(), entity);
        return resource;
    }

    @Override
    public HealtConditionResource toResource(HealtConditionDTO entity) {
        final HealtConditionResource resource = toBaseResources(entity);
        // Add links to available actions
        return resource;
    }

    @Override
    public Link linkToSingleResource(HealtConditionDTO entity) {
        return entityLinks.linkToSingleResource(HealtCondition.class, entity.getHealtConditionUUID());
    }

}
