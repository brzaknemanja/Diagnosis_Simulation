package com.diagnosis.sbnz.dto;

import com.diagnosis.sbnz.model.PatientState;

public class PatientStateDto {
	public int systolicPressure;
	public int diastolicPressure;
	public float pulse;
	public float oxygenSaturation;
	public float temperature;
	
	public static PatientStateDto PatientStateToDto(PatientState patientState) {
		PatientStateDto dto = new PatientStateDto();
		dto.systolicPressure = patientState.getSystolicPressure();
		dto.diastolicPressure = patientState.getDiastolicPressure();
		dto.pulse = patientState.getPulse();
		dto.oxygenSaturation = patientState.getOxygenSaturation();
		dto.temperature = patientState.getTemperature();
		
		return dto;
	}
}
