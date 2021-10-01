package com.accenture.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.school.dto.StudentClassesDto;
import com.accenture.school.exception.RecordNotFoundException;
import com.accenture.school.service.StudentClassesService;

@RestController
public class StudentClassesController {
	@Autowired
	private StudentClassesService studentClassesService;
	
	//Controller route path
	final String BASE_URL = "/studentClasses";
	
	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	private ResponseEntity<StudentClassesDto> getById(@PathVariable("id") long id) 
	{
		StudentClassesDto dto = studentClassesService.getById(id);
		if(dto == null) {
	         throw new RecordNotFoundException("No record found : " + id);
	    }
	    return new ResponseEntity<StudentClassesDto>(dto, HttpStatus.OK);
	}
	

	@RequestMapping(value = BASE_URL, method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	private ResponseEntity<List<StudentClassesDto>> getAll() 
	{
		List<StudentClassesDto> dtos = studentClassesService.getAll();
		if(dtos == null) {
	         throw new RecordNotFoundException("No record found");
	    }
	    return new ResponseEntity<List<StudentClassesDto>>(dtos, HttpStatus.OK);		
	}
	
	@RequestMapping(value = BASE_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Long> create(@RequestBody StudentClassesDto dto) 
	{	
		long id = studentClassesService.create(dto);
		
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Boolean> update(@RequestBody StudentClassesDto dto, @PathVariable("id") long id) 
	{
		boolean updated = studentClassesService.update(dto);
		return new ResponseEntity<Boolean>(updated, HttpStatus.OK);
	}
	
	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Boolean> delete(@PathVariable("id") long id) 
	{
		boolean deleted = studentClassesService.delete(id);
		return new ResponseEntity<Boolean>(deleted, HttpStatus.OK);
	}

}
