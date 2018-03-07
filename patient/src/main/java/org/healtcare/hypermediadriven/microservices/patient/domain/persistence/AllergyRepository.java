package org.healtcare.hypermediadriven.microservices.patient.domain.persistence;

import java.util.List;

import org.healtcare.hypermediadriven.microservices.patient.domain.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {
    /**
     * @param allergyName
     * @return
     */
    public Allergy findByAllergyName(String allergyName);

    // @Query("select a from Allergy a join Patient p where p.patientUUID = :patientUUID")
    // public List<Allergy> findByPatientUUID(@Param("patientUUID") String patientUUID);

    /**
     * @param patientUUID
     * @return
     */
    public List<Allergy> findByPatients_PatientUUID(String patientUUID);

    /**
     * @param allergyUUID
     * @return
     */
    public Allergy findByAllergyUUID(String allergyUUID);

}
