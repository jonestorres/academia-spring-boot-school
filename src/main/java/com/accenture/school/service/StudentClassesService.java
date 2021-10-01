package com.accenture.school.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.school.dto.StudentClassesDto;
import com.accenture.school.exception.BusinessException;
import com.accenture.school.model.StudentClasses;
import com.accenture.school.repository.StudentClassesRepository;
import com.accenture.school.service.interfaces.IStudentClassesService;

@Service
public class StudentClassesService implements IStudentClassesService {

	@Autowired
	private StudentClassesRepository studentClassesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//#region private methods
	private StudentClassesDto modelToDto(StudentClasses studentClasses)
	{
		return modelMapper.map(studentClasses, StudentClassesDto.class);
	}
		
	private StudentClasses dtoToModel(StudentClassesDto dto)
	{
		return modelMapper.map(dto, StudentClasses.class);
	}
	
	private void validate(StudentClassesDto dto)
	{
		if (dto.getClasses() == null) {
			throw new BusinessException("The field Classes is required");
		}
		if (dto.getStudent() == null) {
			throw new BusinessException("The field Student is required");
		}
	}
	//#endregion	
	@Override
	public StudentClassesDto getById(long id) {
		StudentClasses studentClasses = studentClassesRepository.findById(id).get();
		return modelToDto(studentClasses);	
	}

	@Override
	public List<StudentClassesDto> getAll() {
		return studentClassesRepository.findAll()
				.stream()
				.map(this::modelToDto)
				.collect(Collectors.toList());
	}

	@Override
	public long create(StudentClassesDto dto) {
		validate(dto);
		StudentClasses studentClasses = this.dtoToModel(dto);
		StudentClasses created = studentClassesRepository.save(studentClasses);
		
		return created.getId();
	}

	@Override
	public boolean update(StudentClassesDto dto) {
		validate(dto);
		StudentClasses studentClasses = this.dtoToModel(dto);
		studentClassesRepository.save(studentClasses).getId();
		return true;
	}

	@Override
	public boolean delete(long id) {
		studentClassesRepository.deleteById(id);
		return true;
	}

}
