package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.model.Student;

@SpringBootTest
public class StudentDaoImplTest {

	@Autowired
	private StudentDao studentDao;
	
	@Transactional
	@Test
	public void getById() {
		Student student = studentDao.getById(3);
		assertNotNull(student);
		assertEquals("Judy", student.getName());
		assertEquals(100.0, student.getScore());
		assertTrue(student.isGraduate());
		assertNotNull(student.getCreateDate());
	}

	@Transactional
	@Test
	public void deleteById() {
		studentDao.deleteById(3);
		Student student = studentDao.getById(3);
		assertNull(student);
	}
	
	@Transactional
	@Test
	public void insert() {
		Student st = new Student();
		st.setName("Kevin");
		st.setScore(66.2);
		st.setGraduate(true);
		
		Integer sid = studentDao.insert(st);
		
		Student rs = studentDao.getById(sid);
		
		assertNotNull(rs);
		assertEquals("Kevin", rs.getName());
		assertEquals(66.2, rs.getScore());
		assertTrue(rs.isGraduate());
		assertNotNull(rs.getCreateDate());
	}
	
	@Transactional
	@Test
	public void update() {
		Student st = studentDao.getById(3);
		st.setName("John");
		
		studentDao.update(st);
		
		Student rs = studentDao.getById(3);
		assertNotNull(rs);
		assertEquals("John", rs.getName());
	}
}
