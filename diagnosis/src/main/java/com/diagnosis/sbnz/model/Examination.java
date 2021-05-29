package com.diagnosis.sbnz.model;

import java.util.ArrayList;
import java.util.List;

import com.diagnosis.sbnz.model.enums.ExaminationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Examination {
	
	private ExaminationType examinationType;	
	private List<String> results;
	private float resultValue;
		
	public Examination() {
		super();
		this.results = new ArrayList<String>();
	}
	public Examination(ExaminationType examinationType, List<String> results, float resultValue) {
		super();
		this.examinationType = examinationType;
		this.results = results;
		this.resultValue = resultValue;
	}
	public ExaminationType getExaminationType() {
		return examinationType;
	}
	public void setExaminationType(ExaminationType examinationType) {
		this.examinationType = examinationType;
	}
	public List<String> getResults() {
		return results;
	}
	public void setResults(List<String> results) {
		this.results = results;
	}
	public float getResultValue() {
		return resultValue;
	}
	public void setResultValue(float resultValue) {
		this.resultValue = resultValue;
	}
}
