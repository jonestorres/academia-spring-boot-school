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

import com.accenture.school.dto.ClassesDto;
import com.accenture.school.exception.RecordNotFoundException;
import com.accenture.school.service.ClassesService;

@RestController
public class ClassesController {
	@Autowired
	private ClassesService classesService;
	
	//Controller route path
	final String BASE_URL = "/classes";
	
	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	private ResponseEntity<ClassesDto> getById(@PathVariable("id") long id) 
	{
		ClassesDto dto = classesService.getById(id);
		if(dto == null) {
	         throw new RecordNotFoundException("No record found : " + id);
	    }
	    return new ResponseEntity<ClassesDto>(dto, HttpStatus.OK);
	}
	

	@RequestMapping(value = BASE_URL, method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	private ResponseEntity<List<ClassesDto>> getAll() 
	{
		List<ClassesDto> dtos = classesService.getAll();
		if(dtos == null) {
	         throw new RecordNotFoundException("No record found");
	    }
	    return new ResponseEntity<List<ClassesDto>>(dtos, HttpStatus.OK);		
	}
	
	@RequestMapping(value = BASE_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Long> create(@RequestBody ClassesDto dto) 
	{	
		long id = classesService.create(dto);
		
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Boolean> update(@RequestBody ClassesDto dto, @PathVariable("id") long id) 
	{
		boolean updated = classesService.update(dto);
		return new ResponseEntity<Boolean>(updated, HttpStatus.OK);
	}
	
	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Boolean> delete(@PathVariable("id") long id) 
	{
		boolean deleted = classesService.delete(id);
		return new ResponseEntity<Boolean>(deleted, HttpStatus.OK);
	}
}
