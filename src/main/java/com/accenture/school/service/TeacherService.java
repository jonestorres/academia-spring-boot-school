package com.accenture.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.school.model.Teacher;
import com.accenture.school.service.interfaces.ITeacherService;

@Service
public class TeacherService implements ITeacherService{

	@Override
	public Teacher getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long create(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return true;
	}

}
