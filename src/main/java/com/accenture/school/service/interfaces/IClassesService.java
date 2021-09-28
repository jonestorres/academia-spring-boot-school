package com.accenture.school.service.interfaces;

import java.util.List;

import com.accenture.school.model.Classes;

public interface IClassesService {
	
	public Classes getById(long id);
	public List<Classes> getAll();
	public long create(Classes classes);
	public boolean update(Classes classes);
	public boolean delete(long id);
}
