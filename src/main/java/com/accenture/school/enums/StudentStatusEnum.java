package com.accenture.school.enums;

public enum StudentStatusEnum {
	REAPPROVED(0),
	APPROVED(1);
	
	private int value;

	StudentStatusEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

}
