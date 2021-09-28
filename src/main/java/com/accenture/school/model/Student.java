package com.accenture.school.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_STUDENTS")
public class Student extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="RECORD",nullable = false)
	private long record;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY )
	private List<StudentClasses> studentClasses;

	public List<StudentClasses> getStudentClasses() {
		return studentClasses;
	}

	public void setStudentClasses(List<StudentClasses> studentClasses) {
		this.studentClasses = studentClasses;
	}

	public long getRecord() {
		return record;
	}

	public void setRecord(long record) {
		this.record = record;
	}

}
