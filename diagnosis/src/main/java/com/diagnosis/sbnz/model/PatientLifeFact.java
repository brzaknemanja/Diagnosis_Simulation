package com.diagnosis.sbnz.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.diagnosis.sbnz.model.enums.FactType;

public class PatientLifeFact {
	
	FactType factType;
	String factDetail;
	Date start;
	Date end;
	
	
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
	public String getFactDetail() {
		return factDetail;
	}
	public void setFactDetail(String factDetail) {
		this.factDetail = factDetail;
	}
	public int getDurationMonths() {
		LocalDate startDate = this.start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = this.end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
		return (int) Period.between(startDate, endDate).toTotalMonths(); 
	}
	
	public int getDurationYears() {
		LocalDate startDate = this.start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = this.end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
		return Period.between(startDate, endDate).getYears(); 
	}
}
