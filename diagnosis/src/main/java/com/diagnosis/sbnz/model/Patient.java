package com.diagnosis.sbnz.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.diagnosis.sbnz.model.enums.FactType;
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
	List<PotentialDamage> potentialDamages;
	List<Examination> examinations;
	
	public Patient() {
		this.lifeFacts = new ArrayList<PatientLifeFact>();
		this.symptoms = new ArrayList<SymptomType>();
		this.examinations = new ArrayList<Examination>();
		this.potentialDamages = new ArrayList<PotentialDamage>();
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
	public List<Examination> getExaminations() {
		return examinations;
	}
	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}	
	public List<PotentialDamage> getPotentialDamages() {
		return potentialDamages;
	}
	public void setPotentialDamages(List<PotentialDamage> potentialDamages) {
		this.potentialDamages = potentialDamages;
	}

	public static Patient CreateDefaultPatient() {
		Patient patient = new Patient();
		patient.setAge(26);
		patient.setHeight(182);
		patient.setWeight(80);
		patient.setGender(Gender.MALE);
		patient.setPatientState(new PatientState());
		
		Illness illness = new Illness();
		illness.setIllnessType(IllnessType.Droolitis);
		illness.illnessPhase = 1;
		patient.setIllness(illness);
		
		// running for 3 months
		PatientLifeFact fact1 = new PatientLifeFact();
		fact1.setFactType(FactType.Running);
		fact1.setStart(Date.from(LocalDate.now().minusMonths(3).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		fact1.setEnd(new Date());
		
		// smoking for 5 years
		PatientLifeFact fact2 = new PatientLifeFact();
		fact2.setFactType(FactType.Smoking);
		fact2.setStart(Date.from(LocalDate.now().minusYears(5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		fact2.setEnd(new Date());
		
		patient.getLifeFacts().add(fact1);
		patient.getLifeFacts().add(fact2);
			
		return patient;
	}
}
