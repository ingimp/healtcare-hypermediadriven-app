package org.healtcare.hypermediadriven.microservices.patient.api.controllers;

import org.healtcare.hypermediadriven.microservices.patient.api.services.IHealtConditionApiService;
import org.healtcare.hypermediadriven.microservices.patient.business.services.IHealtConditionBusinessService;
import org.healtcare.hypermediadriven.microservices.patient.resources.HealtConditionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@RestController
@ExposesResourceFor(HealtConditionResource.class)
@RequestMapping(value = "healtcare/hypermediadriven/api/v1/healtconditions", produces = "application/hal+json")
public class HealtConditionController {
	@Autowired
	private IHealtConditionApiService<HealtConditionResource> healtConditionApiService;
	@Autowired
	private IHealtConditionBusinessService healtConditionBusinessService;

	@GetMapping
	public ResponseEntity<Resources<HealtConditionResource>> getAllHealtConditions() {
		return ResponseEntity
				.ok(healtConditionApiService.buildResources(healtConditionBusinessService.readAllHealtConditions()));
	}

	@GetMapping(value = "/{uuid}")
	public ResponseEntity<HealtConditionResource> getHealtCondition(@PathVariable(value = "uuid") final String uuid) {
		return null;
	}
}
