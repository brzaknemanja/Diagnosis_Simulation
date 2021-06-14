package com.diagnosis.sbnz.model;

import com.diagnosis.sbnz.model.enums.MedicalProcedureType;

public class MedicalProcedure {
	
	private MedicalProcedureType procedureType;
	
	public MedicalProcedure(MedicalProcedureType procedureType) {
		this.procedureType = procedureType;
	}

	public MedicalProcedureType getProcedureType() {
		return procedureType;
	}	
}
