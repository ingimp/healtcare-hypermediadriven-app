package org.healtcare.hypermediadriven.microservices.patient.resources;

import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@Relation(value = "healtCondition", collectionRelation = "healtConditions")
public class HealtConditionResource extends ResourceWithEmbeddeds {
	private String healtConditionUUID;
	private String healtConditionName;

	@JsonCreator
	public HealtConditionResource(@JsonProperty("healtConditionUUID") String healtConditionUUID,
			@JsonProperty("healtConditionName") String healtConditionName) {
		super();
		this.healtConditionUUID = healtConditionUUID;
		this.healtConditionName = healtConditionName;
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

}
