using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PatientData
{
	public int age;
	public Gender gender;
	public float weight;
	public float height;
	public List<SymptomType> symptoms;
	public PatientState patientState;
	public List<PatientLifeFact> patientLifeFacts;
	public List<Examination> examinations;
	public PatientHealthState currentPatientHealthState;
	public SymptomType currentDangerousSituation;

	public Examination lastExamination;
}

[Serializable]
public class PatientState
{
	public int systolicPressure;
	public int diastolicPressure;
	public float pulse;
	public float oxygenSaturation;
	public float temperature;
}

[Serializable]
public class PatientLifeFact
{
	public string factName;
	public string factDetail;
	public string duration;
}

[Serializable]
public class Examination
{
	public ExaminationType examinationType;
	public List<string> results;
	public float resultValue;
}

public enum SymptomType
{
	None,
	Caughing,
	CaughingBlood,
	Fever,
	RunyNose,
	Tiredness,
	ShortnessBreath,
	ChestPain,
	LungsStopped,
	CardiacArrest,
	Arrhythmia,
	Dizziness
}

public enum Gender
{
	FEMALE,
	MALE
}

public enum ExaminationType
{
	CT,
	MRI,
	Spirometry,
	Leukocytes,
	Cholesterol
}

public enum PatientHealthState
{
	Diagnosing,
	Cured,
	Dead
}
