package com.diagnosis.sbnz.model;

import java.util.Date;

import com.diagnosis.sbnz.model.enums.TherapyType;

public class Therapy {
	
	private TherapyType therapyType;
	private Date therapyStartDate;
		
	public Therapy(TherapyType therapyType, Date therapyStartDate) {
		super();
		this.therapyType = therapyType;
		this.therapyStartDate = therapyStartDate;
	}
	public TherapyType getTherapyType() {
		return therapyType;
	}
	public void setTherapyType(TherapyType therapyType) {
		this.therapyType = therapyType;
	}
	public Date getTherapyStartDate() {
		return therapyStartDate;
	}
	public void setTherapyStartDate(Date therapyStartDate) {
		this.therapyStartDate = therapyStartDate;
	}	
}
