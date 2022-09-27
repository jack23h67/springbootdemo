package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/students")
	public String insert(@RequestBody Student student) {
		studentRepository.save(student);
		return "執行資料庫的 Create 操作";
	}
	
	@PutMapping("/students/{studentId}")
	public String update(@PathVariable Integer studentId,
			             @RequestBody Student student) {
		Student s = studentRepository.findById(studentId).orElse(null);
		if(s != null) {
			s.setName(student.getName());
			studentRepository.save(s);
			return "執行資料庫的 update 操作";
		}else{
			return "update 失敗，數據不存在";
		}		
	}
	
	@DeleteMapping("/students/{studentId}")
	public String delete(@PathVariable Integer studentId) {
		studentRepository.deleteById(studentId);
		return "執行資料庫的 delete 操作";
	}
	
	@GetMapping("/students/{studentId}")
	public Student read(@PathVariable Integer studentId) {
		Student student = studentRepository.findById(studentId).orElse(null);
		return student;
	}
}
