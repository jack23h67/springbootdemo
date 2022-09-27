package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class StudentController {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@PostMapping("/students")
	public String insert(@RequestBody Student student) {
		String sql = "INSERT INTO student(name) VALUES(:studentName)";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("studentName", student.getName());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);
		
		int id = keyHolder.getKey().intValue();
		System.out.println("mySql自動生成的id為："+id);
		
		return "執行 INSERT sql";
	}
	
	@PostMapping("/students/batch")
	public String insertList(@RequestBody List<Student> studentList) {
		String sql = "INSERT INTO student (name) VALUES (:studentName)";
		
		MapSqlParameterSource[] parmentSource = new MapSqlParameterSource[studentList.size()];
		
		for (int i = 0; i < studentList.size();i++) {
			Student student = studentList.get(i);
			
			parmentSource[i] = new MapSqlParameterSource();
			parmentSource[i].addValue("studentName", student.getName());
		}
		
		namedParameterJdbcTemplate.batchUpdate(sql,parmentSource);
		return "執行一批 INSERT sql";
	}
	
	@GetMapping("/students")
	public List<Student> select() {
		String sql = "SELECT id, name FROM student";
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<Student> slist = namedParameterJdbcTemplate.query(sql,map, new StudentRowMapper());
		
		return slist;
	}
	
	@GetMapping("/students/{studentId}")
	public Student select2(@PathVariable Integer studentId) {
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
	
	@DeleteMapping("/students/{studentId}")
	public String delete(@PathVariable Integer studentId) {
		String sql = "DELETE FROM student WHERE id = :studentId";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("studentId", studentId);
		namedParameterJdbcTemplate.update(sql, map);
		
		return "執行DELETE sql";
	}
}
