package org.healtcare.hypermediadriven.microservices.patient.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Patient extends AbstractPersistable<Long> {
    private static final long serialVersionUID = -2001013262866362012L;
    @Column(unique = true)
    private String patientUUID;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String gender;
    @Column(length = 1024)
    private String patientDescription;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "patients_allergies", joinColumns = {
	    @JoinColumn(name = "id_patient", referencedColumnName = "id") }, inverseJoinColumns = {
		    @JoinColumn(name = "id_allergy", referencedColumnName = "id") })
    private Set<Allergy> allergies = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_healtcondition")
    private HealtCondition healtCondition;

    private boolean hospitalized;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String gender) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.patientUUID = UUID.randomUUID().toString() + "_" + this.firstName + "_" + this.lastName;
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

    public Set<Allergy> getAllergies() {
	return allergies;
    }

    public void setAllergies(Set<Allergy> allergies) {
	this.allergies = allergies;
    }

    public void add(Allergy allergy) {
	allergies.add(allergy);
	allergy.getPatients().add(this);
    }

    public HealtCondition getHealtCondition() {
	return healtCondition;
    }

    public void setHealtCondition(HealtCondition healtCondition) {
	this.healtCondition = healtCondition;
    }

    public Patient withPatientUUID(final String patientUUID) {
	this.setPatientUUID(patientUUID);
	return this;
    }

    public Patient withPatientID(Long id) {
	this.setId(id);
	return this;
    }

    public boolean getHospitalized() {
	return hospitalized;
    }

    public void setHospitalized(boolean hospitalized) {
	this.hospitalized = hospitalized;
    }

}
