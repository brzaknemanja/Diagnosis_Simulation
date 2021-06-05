package com.diagnosis.sbnz.dto;

import java.util.ArrayList;
import java.util.List;

import com.diagnosis.sbnz.model.Examination;
import com.diagnosis.sbnz.model.Patient;
import com.diagnosis.sbnz.model.PatientLifeFact;
import com.diagnosis.sbnz.model.enums.Gender;
import com.diagnosis.sbnz.model.enums.SymptomType;

public class PatientDto {
	public int age;
	public Gender gender;
	public float weight;
	public float height;
	public List<Integer> symptoms;
	public PatientStateDto patientState;
	
	public static PatientDto PatientToDto(Patient patient) {
		PatientDto dto = new PatientDto();
		dto.age = patient.getAge();
		dto.gender = patient.getGender();
		dto.weight = patient.getWeight();
		dto.height = patient.getHeight();
		
		dto.symptoms = new ArrayList<Integer>();
		for (int i = 0; i < patient.getSymptoms().size(); i++) {
			dto.symptoms.add(patient.getSymptoms().get(i).ordinal());
		}
		
		dto.patientState = PatientStateDto.PatientStateToDto(patient.getPatientState());
		
		return dto;
	}
}
