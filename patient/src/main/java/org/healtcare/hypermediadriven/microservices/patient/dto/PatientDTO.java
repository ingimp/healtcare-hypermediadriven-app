package org.healtcare.hypermediadriven.microservices.patient.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

public class PatientDTO {
    private String patientUUID;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String gender;
    private String patientDescription;
    private boolean hospitalized;
    private Set<AllergyDTO> allergies = new HashSet<>();
    private HealtConditionDTO healtCondition;

    public PatientDTO() {
    }

    public String getPatientUUID() {
	return patientUUID;
    }

    public void setPatientUUID(String patientUUID) {
	this.patientUUID = patientUUID;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public String getPatientDescription() {
	return patientDescription;
    }

    public void setPatientDescription(String patientDescription) {
	this.patientDescription = patientDescription;
    }

    public boolean getHospitalized() {
	return hospitalized;
    }

    public void setHospitalized(boolean hospitalized) {
	this.hospitalized = hospitalized;
    }

    public Set<AllergyDTO> getAllergies() {
	return allergies;
    }

    public void setAllergies(Set<AllergyDTO> allergies) {
	this.allergies = allergies;
    }

    public HealtConditionDTO getHealtCondition() {
	return healtCondition;
    }

    public void setHealtCondition(HealtConditionDTO healtCondition) {
	this.healtCondition = healtCondition;
    }

    public boolean addAll(Collection<? extends AllergyDTO> c) {
	return allergies.addAll(c);
    }

}
