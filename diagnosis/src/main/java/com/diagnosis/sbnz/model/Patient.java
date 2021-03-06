package com.diagnosis.sbnz.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.diagnosis.sbnz.events.DangerousSituationEvent;
import com.diagnosis.sbnz.model.enums.FactType;
import com.diagnosis.sbnz.model.enums.Gender;
import com.diagnosis.sbnz.model.enums.IllnessType;
import com.diagnosis.sbnz.model.enums.PatientHealthState;
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
	List<Therapy> therapies;
	List<DangerousPatientSituation> dangerousPatientSituations;
	List<DangerousSituationEvent> dangerousSituationEvents;
	PatientHealthState currentPatientHealthState;
	DangerousPatientSituation currentDangerousSituation;
	float illnessProgressionCoefficient;
	
	public Patient() {
		this.lifeFacts = new ArrayList<PatientLifeFact>();
		this.symptoms = new ArrayList<SymptomType>();
		this.examinations = new ArrayList<Examination>();
		this.potentialDamages = new ArrayList<PotentialDamage>();
		this.dangerousSituationEvents = new ArrayList<DangerousSituationEvent>();
		this.dangerousPatientSituations = new ArrayList<DangerousPatientSituation>();
		this.therapies = new ArrayList<Therapy>();
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
	public List<Examination> getExaminations() {
		return examinations;
	}
	public List<PotentialDamage> getPotentialDamages() {
		return potentialDamages;
	}
	public List<DangerousSituationEvent> getDangerousSituationEvents() {
		return dangerousSituationEvents;
	}	
	public List<DangerousPatientSituation> getDangerousPatientSituations() {
		return dangerousPatientSituations;
	}
	public List<Therapy> getTherapies() {
		return therapies;
	}
		
	public PatientHealthState getCurrentPatientHealthState() {
		return currentPatientHealthState;
	}

	public void setCurrentPatientHealthState(PatientHealthState currentPatientHealthState) {
		this.currentPatientHealthState = currentPatientHealthState;
	}
	
	public DangerousPatientSituation getCurrentDangerousSituation() {
		return currentDangerousSituation;
	}

	public void setCurrentDangerousSituation(DangerousPatientSituation currentDangerousSituation) {
		this.currentDangerousSituation = currentDangerousSituation;
	}
	
	public void removeDangerousSituation(SymptomType symptomType) {
		this.dangerousPatientSituations.removeIf(x -> x.dangerousSymptom == symptomType);
	}
	
	public void removeDangerousSituationEvents(SymptomType symptomType) {
		this.dangerousSituationEvents.removeIf(x -> x.getSymptom() == symptomType);
	}
	
	public void IncreaseIllnessProgressionCoefficient(float value) {
		this.illnessProgressionCoefficient += value;
	}
	
	public float getIllnessProgressionCoefficient() {
		return illnessProgressionCoefficient;
	}
	
	public static Patient CreatePatient(int index) {
		switch(index) {
			case 1:
				return CreatePatient1();
			case 2:
				return CreatePatient2();
			case 3:
				return CreatePatient3();
			default:
				return CreatePatient3();
		}		
	}
	
	public static Patient CreatePatient1() {
		Patient patient = new Patient();
		patient.setAge(28);
		patient.setHeight(165);
		patient.setWeight(60);
		patient.setGender(Gender.FEMALE);
		patient.setCurrentPatientHealthState(PatientHealthState.Diagnosing);
		patient.setPatientState(new PatientState());
		
		Illness illness = new Illness();
		illness.setIllnessType(IllnessType.Droolitis);
		illness.illnessPhase = 1;
		patient.setIllness(illness);
		
		// healthy lifestyle
		PatientLifeFact fact1 = new PatientLifeFact();
		fact1.setFactType(FactType.HealthyLifestyle);
		fact1.setStart(Date.from(LocalDate.now().minusYears(3).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		fact1.setEnd(new Date());
				
		patient.getLifeFacts().add(fact1);
			
		return patient;
	}

	public static Patient CreatePatient2() {
		Patient patient = new Patient();
		patient.setAge(26);
		patient.setHeight(182);
		patient.setWeight(80);
		patient.setGender(Gender.MALE);
		patient.setCurrentPatientHealthState(PatientHealthState.Diagnosing);
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
	
	public static Patient CreatePatient3() {
		Patient patient = new Patient();
		patient.setAge(50);
		patient.setHeight(170);
		patient.setWeight(110);
		patient.setGender(Gender.MALE);
		patient.setCurrentPatientHealthState(PatientHealthState.Diagnosing);
		patient.setPatientState(new PatientState());
		
		Illness illness = new Illness();
		illness.setIllnessType(IllnessType.Droolitis);
		illness.illnessPhase = 1;
		patient.setIllness(illness);
		
		// alcoholism for 3 years
		PatientLifeFact fact1 = new PatientLifeFact();
		fact1.setFactType(FactType.Alcoholism);
		fact1.setFactDetail("daily drinking");
		fact1.setStart(Date.from(LocalDate.now().minusYears(3).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		fact1.setEnd(new Date());
		
		// Unhealthy Lifestyle for 5 years
		PatientLifeFact fact2 = new PatientLifeFact();
		fact2.setFactType(FactType.UnhealthyLifestyle);
		fact2.setFactDetail("unhealthy diet, fast food");
		fact2.setStart(Date.from(LocalDate.now().minusYears(5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		fact2.setEnd(new Date());
			
		patient.getLifeFacts().add(fact1);
		patient.getLifeFacts().add(fact2);
			
		return patient;
	}
}
