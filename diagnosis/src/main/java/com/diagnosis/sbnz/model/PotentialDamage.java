package com.diagnosis.sbnz.model;

import com.diagnosis.sbnz.model.enums.PotentialDamageType;

public class PotentialDamage {
	
	PotentialDamageType damageType;

	public PotentialDamage() {
		super();
	}

	public PotentialDamage(PotentialDamageType damageType) {
		super();
		this.damageType = damageType;
	}

	public PotentialDamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(PotentialDamageType damageType) {
		this.damageType = damageType;
	}	
}
