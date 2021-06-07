package com.diagnosis.sbnz.dto;

import java.util.List;

import com.diagnosis.sbnz.model.Examination;


public class ExaminationDto {
	public int examinationType;	
	public List<String> results;
	public float resultValue;
	
	public static ExaminationDto ExaminationToDto(Examination examination) {
		ExaminationDto dto = new ExaminationDto();
		dto.examinationType = examination.getExaminationType().ordinal();
		dto.results = examination.getResults();
		dto.resultValue = examination.getResultValue();
		return dto;
	}
}
