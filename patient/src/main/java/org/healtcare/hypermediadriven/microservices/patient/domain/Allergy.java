package org.healtcare.hypermediadriven.microservices.patient.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToMany;
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
public class Allergy extends AbstractPersistable<Long> {
    private static final long serialVersionUID = 307417702323435030L;
    @Column(unique = true, nullable = false)
    private String allergyUUID;
    @NotBlank
    private String allergyName;
    @Column(length = 1024)
    private String allergyDescription;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @ManyToMany(mappedBy = "allergies")
    private Set<Patient> patients = new HashSet<>();

    public Allergy() {
    }

    public Allergy(String allergyName) {
	super();
	this.allergyName = allergyName;
	this.allergyUUID = UUID.randomUUID().toString() + "_" + this.allergyName;
    }

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

    public Set<Patient> getPatients() {
	return patients;
    }

    public void setPatients(Set<Patient> patients) {
	this.patients = patients;
    }

}
