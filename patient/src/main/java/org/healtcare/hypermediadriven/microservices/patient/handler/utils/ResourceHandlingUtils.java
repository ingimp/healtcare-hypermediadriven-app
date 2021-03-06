package org.healtcare.hypermediadriven.microservices.patient.handler.utils;

import org.healtcare.hypermediadriven.microservices.patient.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Persistable;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
public abstract class ResourceHandlingUtils {

	public static <T extends Persistable<?>> T entityOrNotFoundException(T entity) {
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		return entity;
	}
}
