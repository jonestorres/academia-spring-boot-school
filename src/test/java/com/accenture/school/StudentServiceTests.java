package com.accenture.school;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.school.dto.StudentDto;
import com.accenture.school.service.StudentService;

@SpringBootTest
@RunWith(SpringRunner.class)
class StudentServiceTests {
	
	@MockBean //Mock do serviço
	private StudentService studentService;
	
	@BeforeEach //Mock do dados retornados
	public void setUp() {
	    StudentDto studentDto = new StudentDto();
	    studentDto.setId(1);
	    studentDto.setNome("Gisele");
	    studentDto.setRecord(1);

	    Mockito.when(studentService.getByIdWithClass(anyLong()))
	      .thenReturn(studentDto);
	    
	    Mockito.when(studentService.create(any(StudentDto.class)))
	      .thenReturn(1L);
	}
	
	@Test //Teste do método
	public void whenValidId_then_Student_ShouldBe_Found() {
	    long id = 1;
	    
	    StudentDto found = studentService.getByIdWithClass(id);
	 
	     assertThat(found.getId())
	      .isEqualTo(id);
	 }
	
	@Test
	public void whenPostValid_then_Student_ShouldBe_OK() {
	    StudentDto ok = new StudentDto();
	    ok.setId(1);
	    ok.setNome("Gisele");
	    ok.setRecord(1);
	    
	    long id = studentService.create(ok);
	 
	    assertThat(ok.getId()).isEqualTo(id); 
	 }
	

}
