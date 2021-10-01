package com.accenture.school.service.interfaces;

import java.util.List;

import com.accenture.school.dto.ClassesDto;

public interface IClassesService {
	
	public ClassesDto getById(long id);
	public List<ClassesDto> getAll();
	public long create(ClassesDto dto);
	public boolean update(ClassesDto dto);
	public boolean delete(long id);
}
