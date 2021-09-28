package com.accenture.school.service.interfaces;

import java.util.List;

import com.accenture.school.dto.StudentDto;

public interface IStudentService {
	
	public StudentDto getById(long id);
	public List<StudentDto> getAll();
	public long create(StudentDto dto);
	public boolean update(StudentDto dto);
	public boolean delete(long id);
	
	public StudentDto getByIdWithClass(long id);

}
