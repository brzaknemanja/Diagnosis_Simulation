package com.diagnosis.sbnz.model;

import java.util.ArrayList;
import java.util.List;

import com.diagnosis.sbnz.model.enums.Gender;
import com.diagnosis.sbnz.model.enums.IllnessType;
import com.diagnosis.sbnz.model.enums.SymptomType;

public class Patient {

	int age;
	Gender gender;
	float weight;
	float height;
	public Illness illness;
	PatientState patientState;
	List<PatientLifeFact> lifeFacts;
	List<SymptomType> symptoms;
	
	public Patient() {
		this.lifeFacts = new ArrayList<PatientLifeFact>();
		this.symptoms = new ArrayList<SymptomType>();
	}
	
	public void addSymptom(SymptomType symptom) {
		this.symptoms.add(symptom);
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}	
	public Illness getIllness() {
		return illness;
	}
	public void setIllness(Illness illness) {
		this.illness = illness;
	}	
	public PatientState getPatientState() {
		return patientState;
	}
	public void setPatientState(PatientState patientState) {
		this.patientState = patientState;
	}
	public List<PatientLifeFact> getLifeFacts() {
		return lifeFacts;
	}
	public void setLifeFacts(List<PatientLifeFact> lifeFacts) {
		this.lifeFacts = lifeFacts;
	}
	public List<SymptomType> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<SymptomType> symptoms) {
		this.symptoms = symptoms;
	}

	public static Patient CreateDefaultPatient() {
		Patient patient = new Patient();
		patient.setAge(26);
		patient.setHeight(182);
		patient.setWeight(80);
		patient.setGender(Gender.MALE);
		patient.setPatientState(new PatientState());
		
		Illness illness = new Illness();
		illness.setIllnessType(IllnessType.Flu);
		illness.illnessPhase = 1;
		patient.setIllness(illness);
			
		return patient;
	}
}
