package com.accenture.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.school.service.TeacherService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeacherServiceTests {
	
	@MockBean
	TeacherService teacherService;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	public void whenValidId_then_Teacher_ShouldBe_Found() {
		//metodos de testes
	}

}
