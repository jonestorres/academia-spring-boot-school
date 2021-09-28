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

import com.accenture.school.dto.StudentDto;
import com.accenture.school.exception.RecordNotFoundException;
import com.accenture.school.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	//Controller route path
	final String BASE_URL = "/students";
	
	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	private ResponseEntity<StudentDto> getStudent(@PathVariable("id") long id) 
	{
		StudentDto studentDto = studentService.getById(id);
		if(studentDto == null) {
	         throw new RecordNotFoundException("No record found : " + id);
	    }
	    return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = BASE_URL + "/{id}/classes", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	private ResponseEntity<StudentDto> getStudentWithClasses(@PathVariable("id") long id) 
	{
		StudentDto studentDto = studentService.getByIdWithClass(id);
		if(studentDto == null) {
	         throw new RecordNotFoundException("No record found : " + id);
	    }
	    return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);		
	}

	@RequestMapping(value = BASE_URL, method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	private ResponseEntity<List<StudentDto>> getAll() 
	{
		List<StudentDto> studentDtos = studentService.getAll();
		if(studentDtos == null) {
	         throw new RecordNotFoundException("No record found");
	    }
	    return new ResponseEntity<List<StudentDto>>(studentDtos, HttpStatus.OK);		
	}
	
	@RequestMapping(value = BASE_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Long> createStudent(@RequestBody StudentDto dto) 
	{
		long id = studentService.create(dto);
		
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Boolean> updateStudent(@RequestBody StudentDto dto, @PathVariable("id") long id) 
	{
		boolean updated = studentService.update(dto);
		return new ResponseEntity<Boolean>(updated, HttpStatus.OK);
	}
	
	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	private ResponseEntity<Boolean> createStudent(@PathVariable("id") long id) 
	{
		boolean deleted = studentService.delete(id);
		return new ResponseEntity<Boolean>(deleted, HttpStatus.OK);
	}

}
