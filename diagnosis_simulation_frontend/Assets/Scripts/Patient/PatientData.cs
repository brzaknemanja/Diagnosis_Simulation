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
	FEMALE, MALE
}