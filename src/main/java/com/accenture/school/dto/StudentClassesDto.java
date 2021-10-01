package com.accenture.school.dto;

public class StudentClassesDto {

	private ClassesDto classes;
	private StudentDto student;
	private int evaluation; 
	private String status;

	public ClassesDto getClasses() {
		return classes;
	}

	public void setClasses(ClassesDto classes) {
		this.classes = classes;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

}
