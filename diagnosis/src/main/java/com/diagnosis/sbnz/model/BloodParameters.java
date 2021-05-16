package com.diagnosis.sbnz.model;

public class BloodParameters {
	
	float hemoglobin;
	float leukocytes;
		
	public BloodParameters() {
		this.hemoglobin = 120;
		this.leukocytes = 6;
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
}
