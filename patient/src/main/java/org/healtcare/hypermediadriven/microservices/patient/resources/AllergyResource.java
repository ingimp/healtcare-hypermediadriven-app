package org.healtcare.hypermediadriven.microservices.patient.resources;

import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Relation(value = "allergy", collectionRelation = "allergies")
public class AllergyResource extends ResourceWithEmbeddeds {
    private String allergyUUID;
    private String allergyName;
    private String allergyDescription;

    @JsonCreator
    public AllergyResource(@JsonProperty("allergyUUID") String allergyUUID, @JsonProperty("allergyName") String allergyName, @JsonProperty("allergyDescription") String allergyDescription) {
        super();
        this.allergyUUID = allergyUUID;
        this.allergyName = allergyName;
        this.allergyDescription = allergyDescription;
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

}
