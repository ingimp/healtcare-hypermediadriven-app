package org.healtcare.hypermediadriven.microservices.patient.domain.persistence;

import org.healtcare.hypermediadriven.microservices.patient.domain.HealtCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Repository
public interface HealtConditionRepository extends JpaRepository<HealtCondition, Long> {

	public HealtCondition findByHealtConditionName(String healConditionName);

	public HealtCondition findByPatients_PatientUUID(String patientUUID);
}
