package com.accenture.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="TB_TEACHERS")
public class Teacher extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	private long record;

	@Column(name="RECORD",nullable = false)
	public long getRecord() {
		return record;
	}

	public void setRecord(long record) {
		this.record = record;
	}
	

}
