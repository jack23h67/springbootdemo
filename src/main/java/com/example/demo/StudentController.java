package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	@Qualifier("test1JdbcTemplate")
	private NamedParameterJdbcTemplate test1JdbcTemplate;
	
	@Autowired
	@Qualifier("test2JdbcTemplate")
	private NamedParameterJdbcTemplate test2JdbcTemplate;
	
	@PostMapping("/test1/students")
	public String test1insert(@RequestBody Student student) {
		String sql = "INSERT INTO student(name) VALUES(:studentName)";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("studentName", student.getName());
		
		test1JdbcTemplate.update(sql, map);

		return "插入數據到 test1 資料庫";
	}
	
	@PostMapping("/test2/students")
	public String test2insert(@RequestBody Student student) {
		String sql = "INSERT INTO student(name) VALUES(:studentName)";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("studentName", student.getName());
		
		test2JdbcTemplate.update(sql, map);

		return "插入數據到 test2 資料庫";
	}
	
}
