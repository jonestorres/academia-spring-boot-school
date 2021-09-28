package com.accenture.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.accenture.school.enums.StudentStatusEnum;

@Entity
@Table(name="TB_STUDENTS_CLASSES")
public class StudentClasses extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_Id", nullable = false)
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classes_Id", nullable = false)
	private Classes classes;
	
	private int evaluation;
	
	@Column(name = "status", nullable = false)
	private StudentStatusEnum status;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public StudentStatusEnum getStatus() {
		return status;
	}
	public void setStatus(StudentStatusEnum status) {
		this.status = status;
	}

}
