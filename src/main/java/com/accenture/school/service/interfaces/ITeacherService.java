package com.accenture.school.service.interfaces;

import java.util.List;

import com.accenture.school.model.Teacher;

public interface ITeacherService {

	public Teacher getById(long id);
	public List<Teacher> getAll();
	public long create(Teacher teacher);
	public boolean update(Teacher teacher);
	public boolean delete(long id);
}
