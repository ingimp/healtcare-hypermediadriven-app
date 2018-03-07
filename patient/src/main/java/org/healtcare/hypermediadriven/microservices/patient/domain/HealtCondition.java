package org.healtcare.hypermediadriven.microservices.patient.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HealtCondition extends AbstractPersistable<Long> {
    private static final long serialVersionUID = 5023540316077317981L;

    @Column(unique = true)
    private String healtConditionUUID;
    @NotBlank
    private String healtConditionName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "healtCondition")
    private Set<Patient> patients = new HashSet<>();

    public HealtCondition() {
    }

    public HealtCondition(String healtConditionName) {
        super();
        this.healtConditionName = healtConditionName;
        this.healtConditionUUID = UUID.randomUUID().toString() + "_" + this.healtConditionName;
    }

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

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

}
