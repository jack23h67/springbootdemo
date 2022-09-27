package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Student;
import com.example.demo.dao.StudentDao;

@Component
public class SudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public Student getById(Integer studentId) {
		return studentDao.getById(studentId);
	}
	

}
