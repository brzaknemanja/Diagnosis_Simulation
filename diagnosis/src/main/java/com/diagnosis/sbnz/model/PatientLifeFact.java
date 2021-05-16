package com.diagnosis.sbnz.model;

import java.util.Date;
import java.util.List;

import com.diagnosis.sbnz.model.enums.FactType;

public class PatientLifeFact {
	
	FactType factType;
	Date start;
	Date end;
	List<String> factDetails;
	
	public FactType getFactType() {
		return factType;
	}
	public void setFactType(FactType factType) {
		this.factType = factType;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public List<String> getFactDetails() {
		return factDetails;
	}
	public void setFactDetails(List<String> factDetails) {
		this.factDetails = factDetails;
	}
}
