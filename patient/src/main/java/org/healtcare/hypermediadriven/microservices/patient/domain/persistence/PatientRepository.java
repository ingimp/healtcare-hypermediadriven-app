package org.healtcare.hypermediadriven.microservices.patient.domain.persistence;

import org.healtcare.hypermediadriven.microservices.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    public Patient findByFirstNameAndLastName(String firstName, String lastName);

    // @Query("select p from Patient p where p.patientUUID = :patientUUID")
    // public Patient findByPatientUUID(@Param("patientUUID") String patientUUID);

    public Patient findByPatientUUID(String patientUUID);

}
