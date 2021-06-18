package com.diagnosis.sbnz.model;

public class BloodParameters {
	
	float hemoglobin;
	float leukocytes;
	float cholesterol;
		
	public BloodParameters() {
		this.hemoglobin = 120;
		this.leukocytes = 6;
		this.cholesterol = 4;
	}
	public float getHemoglobin() {
		return hemoglobin;
	}
	public void setHemoglobin(float hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public float getLeukocytes() {
		return leukocytes;
	}
	public void setLeukocytes(float leukocytes) {
		this.leukocytes = leukocytes;
	}
	public float getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(float cholesterol) {
		this.cholesterol = cholesterol;
	}
	
	
}
