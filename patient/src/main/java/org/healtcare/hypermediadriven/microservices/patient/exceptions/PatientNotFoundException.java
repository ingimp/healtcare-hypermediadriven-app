package org.healtcare.hypermediadriven.microservices.patient.exceptions;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class PatientNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1534813405057304893L;

    private final String id;

    public PatientNotFoundException(String id) {
	super("Patient could not be found with id: " + id);
	this.id = id;
    }

    public String getId() {
	return id;
    }
}
