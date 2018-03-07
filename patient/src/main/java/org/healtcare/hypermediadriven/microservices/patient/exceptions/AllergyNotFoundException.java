package org.healtcare.hypermediadriven.microservices.patient.exceptions;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
public class AllergyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6531870777526020103L;

	private final String id;

	public AllergyNotFoundException(String id) {
		super("Allergy could not be found with id: " + id);
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
