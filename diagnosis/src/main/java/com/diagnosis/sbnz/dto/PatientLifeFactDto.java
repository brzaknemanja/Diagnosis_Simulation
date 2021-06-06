package com.diagnosis.sbnz.dto;


import com.diagnosis.sbnz.model.PatientLifeFact;

public class PatientLifeFactDto {
	public String factName;
	public String factDetail;
	public String duration;
	
	public static PatientLifeFactDto LifeFactToDto(PatientLifeFact lifeFact) {
		PatientLifeFactDto dto = new PatientLifeFactDto();
		dto.factName = lifeFact.getFactType().toString();
		dto.factDetail = lifeFact.getFactDetail();
		dto.duration = PatientLifeFactDto.GetFactDurationString(lifeFact);
		return dto;
	}
	
	private static String GetFactDurationString(PatientLifeFact lifeFact) {
		int years = lifeFact.getDurationYears();
		if (years > 0)
		{
			if (years == 1)
				return years + " year";
			else
				return years + " years";
		}
					
		int months = lifeFact.getDurationMonths();
		if (months > 0)
		{
			if (months == 1)
				return months + " month";
			else
				return months + " months";
		}
		
		return "";
	}
}
