package com.dignosis.sbnz;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diagnosis.sbnz.model.Patient;

@RestController
public class Controller {
	
	@Autowired
	KieContainer kieContainer;
	
	Patient patient;
	
	@GetMapping(value="getPatient")
	public Patient getPatient() {
		
		if (this.patient == null)
			this.patient = Patient.CreateDefaultPatient();
		
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(this.patient);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return patient;
	}
	
	@GetMapping(value="simulate")
	public Patient simulateIllnessPhase() {	
		
		this.patient.getIllness().increaseIllnessPhase();
		
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(this.patient);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return patient;
	}
}

