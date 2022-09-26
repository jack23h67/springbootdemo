package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@PostMapping("/students")
	public String insert() {
		String sql = "INSERT INTO student(id,name) VALUES(3,'John')";
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		namedParameterJdbcTemplate.update(sql, map);
		
		return "執行INSERT sql";
	}

}
