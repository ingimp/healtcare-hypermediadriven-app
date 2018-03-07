package org.healtcare.hypermediadriven.microservices.patient.api.controllers;

import org.healtcare.hypermediadriven.microservices.patient.api.services.IAllergyApiService;
import org.healtcare.hypermediadriven.microservices.patient.business.services.IAllergyBusinessService;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.AllergyNotFoundException;
import org.healtcare.hypermediadriven.microservices.patient.resources.AllergyResource;
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
@ExposesResourceFor(AllergyResource.class)
@RequestMapping(value = "healtcare/hypermediadriven/api/v1/allergies", produces = "application/hal+json")
public class AllergyController {
	@Autowired
	private IAllergyBusinessService allergyBusinessService;
	@Autowired
	private IAllergyApiService<AllergyResource> allergyApiService;

	@GetMapping
	public ResponseEntity<Resources<AllergyResource>> getAllAllergies() {
		return null;
	}

	/**
	 * @param uuid
	 * @return
	 */
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<AllergyResource> getAllergy(@PathVariable(value = "uuid") final String uuid) {
		return allergyApiService.buildResourceAsOptional(allergyBusinessService.readAllergy(uuid))
				.map(a -> ResponseEntity.ok(a)).orElseThrow(() -> new AllergyNotFoundException(uuid));

	}

}
