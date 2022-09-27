package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Student;
import com.example.demo.StudentRowMapper;

@Component
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Student getById(Integer studentId) {
		String sql = "SELECT id, name FROM student WHERE id = :studentId";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("studentId", studentId);
		
		List<Student> slist = namedParameterJdbcTemplate.query(sql,map, new StudentRowMapper());
		
		if(slist.size()>0) {
			return slist.get(0);
		}else {
			return null;
		}
	}

}
