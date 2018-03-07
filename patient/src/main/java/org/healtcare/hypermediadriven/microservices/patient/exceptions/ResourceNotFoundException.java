package org.healtcare.hypermediadriven.microservices.patient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
