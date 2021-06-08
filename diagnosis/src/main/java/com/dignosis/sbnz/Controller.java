package com.dignosis.sbnz;

import java.util.Date;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diagnosis.sbnz.dto.ExaminationDto;
import com.diagnosis.sbnz.dto.PatientDto;
import com.diagnosis.sbnz.model.Examination;
import com.diagnosis.sbnz.model.Patient;
import com.diagnosis.sbnz.model.Therapy;
import com.diagnosis.sbnz.model.enums.ExaminationType;
import com.diagnosis.sbnz.model.enums.IllnessType;
import com.diagnosis.sbnz.model.enums.TherapyType;

@RestController
public class Controller {
	
	@Autowired
	KieContainer kieContainer;
	
	Patient patient;
	
	@GetMapping(value="initialize")
	public PatientDto initializeIllness(@RequestParam IllnessType illnessType) {
		
		if (this.patient == null)
			this.patient = Patient.CreateDefaultPatient(illnessType);
		
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.getAgenda().getAgendaGroup("illness-init").setFocus();
		kieSession.insert(this.patient);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		
		return PatientDto.PatientToDto(this.patient);
	}
	
	@GetMapping(value="getPatient")
	public Patient getPatient() {		
		if (this.patient == null)
			return null;
				
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(this.patient);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return this.patient;
	}
	
	@GetMapping(value="simulate")
	public PatientDto simulateIllnessPhase() {			
		if (this.patient == null)
			return null;
		
		this.patient.getIllness().increaseIllnessPhase();
		
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(this.patient);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return PatientDto.PatientToDto(this.patient);
	}
	
	@GetMapping(value="examine")
	public PatientDto examinePatient(@RequestParam ExaminationType examinationType) {
	
		if (this.patient == null)
			return null;
		
		System.out.println(examinationType);
		
		Examination examination = new Examination();
		examination.setExaminationType(examinationType);
		
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(this.patient);
		kieSession.insert(examination);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		PatientDto dto = PatientDto.PatientToDto(this.patient);
		dto.lastExamination = ExaminationDto.ExaminationToDto(examination);
		
		return dto;
	}
	
	@GetMapping(value="therapy")
	public PatientDto addPatientTherapy(@RequestParam TherapyType therapyType) {
	
		if (this.patient == null)
			return null;
		
		System.out.println(therapyType);
		
		Therapy therapy = new Therapy(therapyType, new Date());
		
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(this.patient);
		kieSession.insert(therapy);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		PatientDto dto = PatientDto.PatientToDto(this.patient);
		
		return dto;
	}
}

