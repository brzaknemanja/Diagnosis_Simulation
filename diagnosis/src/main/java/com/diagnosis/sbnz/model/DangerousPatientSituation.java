package com.diagnosis.sbnz.model;

import com.diagnosis.sbnz.model.enums.SymptomType;

public class DangerousPatientSituation {
	SymptomType dangerousSymptom;
	
	public DangerousPatientSituation(SymptomType dangerousSymptom) {
		super();
		this.dangerousSymptom = dangerousSymptom;
	}

	public SymptomType getDangerousSymptom() {
		return dangerousSymptom;
	}

	public void setDangerousSymptom(SymptomType dangerousSymptom) {
		this.dangerousSymptom = dangerousSymptom;
	}	
}
