package com.accenture.school.service.interfaces;

import java.util.List;

import com.accenture.school.dto.StudentClassesDto;

public interface IStudentClassesService {

	public StudentClassesDto getById(long id);
	public List<StudentClassesDto> getAll();
	public long create(StudentClassesDto dto);
	public boolean update(StudentClassesDto dto);
	public boolean delete(long id);
}
