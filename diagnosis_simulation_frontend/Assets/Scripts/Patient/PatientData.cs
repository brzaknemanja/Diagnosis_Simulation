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

public enum SymptomType
{
	Caughing,
	CaughingBlood,
	Fever,
	RunyNose,
	Tiredness,
	ShortnessBreath,
	ChestPain,
	LungsStopped,
}

public enum Gender
{
	FEMALE,
	MALE
}