package org.healtcare.hypermediadriven.microservices.patient.business.services;

import org.healtcare.hypermediadriven.microservices.patient.dto.HealtConditionDTO;
import org.healtcare.hypermediadriven.microservices.patient.exceptions.HypermediaGenericException;

/**
 * @author ldicesare
 *
 */
public interface IHealtConditionBusinessService {

    /**
     * @param patientUUID
     * @return
     * @throws HypermediaGenericException
     */
    public HealtConditionDTO readHealtConditionByPatient(String patientUUID) throws HypermediaGenericException;

}
