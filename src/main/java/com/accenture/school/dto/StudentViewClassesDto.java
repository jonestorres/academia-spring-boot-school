package com.accenture.school.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentViewClassesDto extends StudentDto {

	@JsonProperty("titles")
	private List<StudentClassesDto> studentClasses;

	public List<StudentClassesDto> getStudentClasses() {
		return studentClasses;
	}

	public void setStudentClasses(List<StudentClassesDto> studentClasses) {
		this.studentClasses = studentClasses;
	}
	
	

}
