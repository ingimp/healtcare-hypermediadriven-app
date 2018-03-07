package org.healtcare.hypermediadriven.microservices.patient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AllergyDTO {
    private String allergyUUID;
    private String allergyName;
    private String allergyDescription;

    @JsonIgnore
    private String patientUUID;

    public String getAllergyUUID() {
        return allergyUUID;
    }

    public void setAllergyUUID(String allergyUUID) {
        this.allergyUUID = allergyUUID;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public String getAllergyDescription() {
        return allergyDescription;
    }

    public void setAllergyDescription(String allergyDescription) {
        this.allergyDescription = allergyDescription;
    }

    public String getPatientUUID() {
        return patientUUID;
    }

    public void setPatientUUID(String patientUUID) {
        this.patientUUID = patientUUID;
    }

}
