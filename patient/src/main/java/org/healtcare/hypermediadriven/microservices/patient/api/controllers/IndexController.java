package org.healtcare.hypermediadriven.microservices.patient.api.controllers;

import org.healtcare.hypermediadriven.microservices.patient.assembler.IndexResourceAssembler;
import org.healtcare.hypermediadriven.microservices.patient.resources.IndexResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("healtcare/hypermediadriven/api/v1/")
public class IndexController {

	private final IndexResourceAssembler indexResourceAssembler;

	@Autowired
	public IndexController(IndexResourceAssembler indexResourceAssembler) {
		this.indexResourceAssembler = indexResourceAssembler;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<IndexResource> index() {
		return ResponseEntity.ok(indexResourceAssembler.buildIndex());
	}
}
