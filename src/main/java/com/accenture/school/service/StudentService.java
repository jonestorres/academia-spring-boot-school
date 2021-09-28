package com.accenture.school.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.school.dto.StudentDto;
import com.accenture.school.dto.StudentViewClassesDto;
import com.accenture.school.exception.BusinessException;
import com.accenture.school.model.Student;
import com.accenture.school.repository.StudentRepository;
import com.accenture.school.service.interfaces.IStudentService;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//#region private methods
	private StudentDto modelToDto(Student student)
	{
		return modelMapper.map(student, StudentDto.class);
	}
		
	private Student dtoToModel(StudentDto dto)
	{
		return modelMapper.map(dto, Student.class);
	}
	
	private StudentViewClassesDto modelToViewClassesDto(Student student)
	{
		return modelMapper.map(student, StudentViewClassesDto.class);
	}
	
	private void validate(StudentDto dto)
	{
		if (dto.getName() == null || dto.getName().isEmpty()) {
			throw new BusinessException("The field Student Name is required");
		}
		if (dto.getRecord() <= 0) {
			throw new BusinessException("The field Student Record is required");
		}
	}
	//#endregion
	
	@Override
	public StudentDto getById(long id) {
		Student student = studentRepository.findById(id).get();
		return modelToDto(student);	
	}

	@Override
	public List<StudentDto> getAll() {
		return studentRepository.findAll()
			.stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}

	@Override
	public long create(StudentDto dto) {
		validate(dto);
		Student student = this.dtoToModel(dto);
		Student created = studentRepository.save(student);
		
		return created.getId();
	}

	@Override
	public boolean update(StudentDto dto) {
		validate(dto);
		Student student = this.dtoToModel(dto);
		studentRepository.save(student).getId();
		return true;
	}

	@Override
	public boolean delete(long id) {
		studentRepository.deleteById(id);
		return true;
	}

	@Override
	public StudentDto getByIdWithClass(long id) {
		Student student = studentRepository.getByIdWithClasses(id);
		return modelToViewClassesDto(student);
	}

}
