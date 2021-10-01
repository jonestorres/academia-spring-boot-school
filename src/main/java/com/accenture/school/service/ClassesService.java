package com.accenture.school.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.school.dto.ClassesDto;
import com.accenture.school.exception.BusinessException;
import com.accenture.school.model.Classes;
import com.accenture.school.repository.ClassesRepostitory;
import com.accenture.school.service.interfaces.IClassesService;

@Service
public class ClassesService implements IClassesService{

	@Autowired
	private ClassesRepostitory classesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//#region private methods
	private ClassesDto modelToDto(Classes classes)
	{
		return modelMapper.map(classes, ClassesDto.class);
	}
		
	private Classes dtoToModel(ClassesDto dto)
	{
		return modelMapper.map(dto, Classes.class);
	}
	
	
	private void validate(ClassesDto dto)
	{
		if (dto.getName() == null || dto.getName().isEmpty()) {
			throw new BusinessException("The field Classes Name is required");
		}
	}
	//#endregion
		
	@Override
	public ClassesDto getById(long id) {
		Classes classes = classesRepository.findById(id).get();
		return modelToDto(classes);	
	}

	@Override
	public List<ClassesDto> getAll() {
		return classesRepository.findAll()
				.stream()
				.map(this::modelToDto)
				.collect(Collectors.toList());
	}

	@Override
	public long create(ClassesDto dto) {
		validate(dto);
		Classes classes = this.dtoToModel(dto);
		Classes created = classesRepository.save(classes);
		
		return created.getId();
	}

	@Override
	public boolean update(ClassesDto dto) {
		validate(dto);
		Classes classes = this.dtoToModel(dto);
		classesRepository.save(classes).getId();
		return true;
	}

	@Override
	public boolean delete(long id) {
		classesRepository.deleteById(id);
		return true;
	}

}
