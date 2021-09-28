package com.accenture.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_CLASSES")
public class Classes extends BaseModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="NAME",nullable = false)
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
