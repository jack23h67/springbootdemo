package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@SpringBootTest
public class StudentServiceImplMockTest {

	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentDao studentDao;
	
	@Test
	public void testGetById() {
		Student mockst = new Student();
		mockst.setId(100);
		mockst.setName("I'm mock");
		
		Mockito.when(studentDao.getById(Mockito.any())).thenReturn(mockst);
		//Mockito.doReturn(mockst).when(studentDao.getById(Mockito.any()));
		
		//Mockito.when(studentDao.insert(Mockito.any())).thenThrow(new RuntimeException());
		//Mockito.doThrow(new RuntimeException()).when(studentDao.insert(Mockito.any()));
		
		//Mockito.verify(studentDao, Mockito.times(2)).getById(Mockito.any());
		
		Student st = studentService.getById(3);
		assertNotNull(st);
		assertEquals(100, st.getId());
		assertEquals("I'm mock", st.getName());
	}

}
