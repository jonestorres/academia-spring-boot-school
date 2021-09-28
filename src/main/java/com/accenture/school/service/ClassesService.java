package com.accenture.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.school.model.Classes;
import com.accenture.school.service.interfaces.IClassesService;

@Service
public class ClassesService implements IClassesService{

	@Override
	public Classes getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Classes> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long create(Classes classes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Classes classes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
