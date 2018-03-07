package org.healtcare.hypermediadriven.microservices.patient.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.healtcare.hypermediadriven.microservices.patient.api.controllers.PatientController;
import org.healtcare.hypermediadriven.microservices.patient.dto.AllergyDTO;
import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.healtcare.hypermediadriven.microservices.patient.dto.PatientDTO;
import org.healtcare.hypermediadriven.microservices.patient.resources.AllergyResource;
import org.healtcare.hypermediadriven.microservices.patient.resources.HealtConditionResource;
import org.healtcare.hypermediadriven.microservices.patient.resources.PatientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.stereotype.Service;

@Service
public class PatientResourceAssembler
	extends EmbeddableResourceAssemblerSupport<PatientDTO, PatientResource, PatientController> {
    @Autowired
    private AllergyResourceAssembler allergyResourceAssembler;
    @Autowired
    private HealtConditionAssembler healtConditionAssembler;

    public PatientResourceAssembler(EntityLinks entityLinks, RelProvider relProvider) {
	super(entityLinks, relProvider, PatientController.class, PatientResource.class);
    }

    @Override
    protected PatientResource instantiateResource(PatientDTO entity) {
	return new PatientResource(entity.getPatientUUID(), entity.getFirstName(), entity.getLastName(),
		entity.getGender(), entity.getPatientDescription());
    }

    private PatientResource toBaseResource(PatientDTO entity) {
	final PatientResource resource = createResourceWithId(entity.getPatientUUID(), entity);
	return resource;
    }

    @Override
    public PatientResource toResource(PatientDTO entity) {
	final PatientResource resource = toBaseResource(entity);
	// FIXME: probabile bug (non setta i valori boolean)
	resource.setHospitalized(entity.getHospitalized());
	// Add links to available actions
	this.addActionLinks(resource, entity);
	// Add allergies as link
	final String allergiesRel = relProvider.getCollectionResourceRelFor(AllergyResource.class);
	for (AllergyDTO allergy : entity.getAllergies()) {
	    resource.add(allergyResourceAssembler.linkToSingleResource(allergy).withRel(allergiesRel));
	}
	// Add healtCondition as link
	final String healtConditionRel = relProvider.getItemResourceRelFor(HealtConditionResource.class);
	HealtConditionDTO healtCondition = entity.getHealtCondition();
	resource.add(healtConditionAssembler.linkToSingleResource(healtCondition).withRel(healtConditionRel));
	return resource;
    }

    private void addActionLinks(final PatientResource resource, final PatientDTO entity) {
	String patientUUID = entity.getPatientUUID();
	// hospitalize or absolve
	final Link hospitalizedLink = entity.getHospitalized()
		? linkTo(methodOn(controllerClass).deHospitalizePatient(patientUUID)).withRel("dehospitalize")
		: linkTo(methodOn(controllerClass).hospitalizePatient(patientUUID)).withRel("hospitalize");
	resource.add(hospitalizedLink);

    }

    public PatientResource toDetailedResource(final PatientDTO entity) {
	final PatientResource resource = toResource(entity);
	// Create the collection of embeddables of different types
	final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
	// Add allergies
	embeddables.addAll(allergyResourceAssembler.toEmbeddable(entity.getAllergies()));
	// Add healtCondition
	embeddables.add(healtConditionAssembler.toEmbeddable(entity.getHealtCondition()));
	resource.setEmbeddeds(new Resources<>(embeddables));
	return resource;
    }

    @Override
    public Link linkToSingleResource(PatientDTO entity) {
	// TODO Auto-generated method stub
	return null;
    }

}
