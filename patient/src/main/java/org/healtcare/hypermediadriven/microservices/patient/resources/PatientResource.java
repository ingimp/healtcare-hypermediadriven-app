package org.healtcare.hypermediadriven.microservices.patient.resources;

import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Relation(value = "patient", collectionRelation = "patients")
public class PatientResource extends ResourceWithEmbeddeds {
	private String patientUUID;
	private String firstName;
	private String lastName;
	private String gender;
	private String patientDescription;
	private boolean hospitalized;

	protected PatientResource() {
	}

	@JsonCreator
	public PatientResource(@JsonProperty("patientUUID") String patientUUID, @JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName, @JsonProperty("gender") String gender,
			@JsonProperty("patientDescription") String patientDescription) {
		super();
		this.patientUUID = patientUUID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.patientDescription = patientDescription;
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

}
