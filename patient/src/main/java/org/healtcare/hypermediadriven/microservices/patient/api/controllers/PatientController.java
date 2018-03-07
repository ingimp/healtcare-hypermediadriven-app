package org.healtcare.hypermediadriven.microservices.patient.api.controllers;

import javax.validation.Valid;

import org.healtcare.hypermediadriven.microservices.patient.api.services.IPatientApiService;
import org.healtcare.hypermediadriven.microservices.patient.business.services.IPatientBusinessService;
import org.healtcare.hypermediadriven.microservices.patient.dto.PatientDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.PatientNotFoundException;
import org.healtcare.hypermediadriven.microservices.patient.resources.PatientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ldicesare
 *
 */
@RestController
@ExposesResourceFor(PatientResource.class)
@RequestMapping(value = "healtcare/hypermediadriven/api/v1/patients", produces = "application/hal+json")
public class PatientController {
    @Autowired
    private IPatientBusinessService<PatientDTO> patientBusinessService;
    @Autowired
    private IPatientApiService<PatientResource> patientApiService;

    @GetMapping
    public ResponseEntity<Resources<PatientResource>> showAllPatients() {
	return ResponseEntity.ok(patientApiService.buildResources(patientBusinessService.readAllPatients()));
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<PatientResource> showPatient(@PathVariable(value = "uuid") final String uuid,
	    @RequestParam(value = "detailed", required = false, defaultValue = "false") boolean detailed) {
	return patientApiService.buildResourceAsOptional(patientBusinessService.readPatient(uuid), detailed)
		.map(p -> ResponseEntity.ok(p)).orElseThrow(() -> new PatientNotFoundException(uuid));

    }

    @PostMapping
    public ResponseEntity<Void> newPatient(@Valid @RequestBody final PatientDTO newPatient) {
	patientBusinessService.createPatient(newPatient);
	return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{uuid}/hospitalize")
    public ResponseEntity<Void> hospitalizePatient(@PathVariable(value = "uuid") final String uuid) {
	PatientDTO patient = patientBusinessService.readPatient(uuid);
	patient.setHospitalized(true);
	patientBusinessService.hospitalize(patient);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{uuid}/dehospitalize")
    public ResponseEntity<Void> deHospitalizePatient(@PathVariable(value = "uuid") final String uuid) {
	PatientDTO patient = patientBusinessService.readPatient(uuid);
	patient.setHospitalized(false);
	patientBusinessService.hospitalize(patient);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
