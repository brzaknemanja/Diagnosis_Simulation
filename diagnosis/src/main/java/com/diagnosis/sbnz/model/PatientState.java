package com.diagnosis.sbnz.model;

public class PatientState {

	int systolicPressure;
	int diastolicPressure;
	float pulse;
	float oxygenSaturation;
	float temperature;
	BloodParameters bloodParameters;
	
	public PatientState() {
		this.systolicPressure = 120;
		this.diastolicPressure = 80;
		this.pulse = 60;
		this.oxygenSaturation = 0.95f;
		this.temperature = 36;
		this.bloodParameters = new BloodParameters();
	}
	
	public int getSystolicPressure() {
		return systolicPressure;
	}
	public void setSystolicPressure(int systolicPressure) {
		this.systolicPressure = systolicPressure;
	}
	public int getDiastolicPressure() {
		return diastolicPressure;
	}
	public void setDiastolicPressure(int diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}
	public float getPulse() {
		return pulse;
	}
	public void setPulse(float pulse) {
		this.pulse = pulse;
	}
	public float getOxygenSaturation() {
		return oxygenSaturation;
	}
	public void setOxygenSaturation(float oxygenSaturation) {
		this.oxygenSaturation = oxygenSaturation;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public BloodParameters getBloodParameters() {
		return bloodParameters;
	}
	public void setBloodParameters(BloodParameters bloodParameters) {
		this.bloodParameters = bloodParameters;
	}	
}
