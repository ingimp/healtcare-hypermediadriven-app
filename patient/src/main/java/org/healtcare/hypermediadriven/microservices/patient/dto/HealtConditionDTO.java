package org.healtcare.hypermediadriven.microservices.patient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HealtConditionDTO {
    private String healtConditionUUID;
    private String healtConditionName;

    @JsonIgnore
    private String patientUUID;

    public String getHealtConditionUUID() {
        return healtConditionUUID;
    }

    public void setHealtConditionUUID(String healtConditionUUID) {
        this.healtConditionUUID = healtConditionUUID;
    }

    public String getHealtConditionName() {
        return healtConditionName;
    }

    public void setHealtConditionName(String healtConditionName) {
        this.healtConditionName = healtConditionName;
    }

    public String getPatientUUID() {
        return patientUUID;
    }

    public void setPatientUUID(String patientUUID) {
        this.patientUUID = patientUUID;
    }

}
