package com.diagnosis.sbnz.model;

import com.diagnosis.sbnz.model.enums.IllnessType;

public class Illness {

	IllnessType illnessType;
	int illnessPhase;
	
	public void increaseIllnessPhase() {
		illnessPhase++;
		if (illnessPhase > 10)
			illnessPhase = 10;
	}
	
	public IllnessType getIllnessType() {
		return illnessType;
	}
	public void setIllnessType(IllnessType illnessType) {
		this.illnessType = illnessType;
	}
	public int getIllnessPhase() {
		return illnessPhase;
	}
	public void setIllnessPhase(int illnessPhase) {
		this.illnessPhase = illnessPhase;
	}
}
