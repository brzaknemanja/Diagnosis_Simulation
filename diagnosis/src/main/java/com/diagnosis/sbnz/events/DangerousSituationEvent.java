package com.diagnosis.sbnz.events;

import java.io.Serializable;

import com.diagnosis.sbnz.model.enums.SymptomType;

@org.kie.api.definition.type.Role(org.kie.api.definition.type.Role.Type.EVENT)
@org.kie.api.definition.type.Expires("2h30m")
public class DangerousSituationEvent implements Serializable {

	SymptomType symptom;
	
	public DangerousSituationEvent(SymptomType symptom) {
		super();
		this.symptom = symptom;
	}

	public SymptomType getSymptom() {
		return symptom;
	}

	public void setSymptom(SymptomType symptom) {
		this.symptom = symptom;
	}
}
