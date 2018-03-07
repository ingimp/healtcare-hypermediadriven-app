package org.healtcare.hypermediadriven.microservices.patient.exceptions;

public class HealtConditionNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6067381441383492388L;

    private final String id;

    public HealtConditionNotFoundException(String id) {
	super("HealtCondition could not be found with id: " + id);
	this.id = id;
    }

    public String getId() {
	return id;
    }

}
