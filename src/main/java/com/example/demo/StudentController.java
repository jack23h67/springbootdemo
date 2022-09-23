package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	//@RequestMapping(value = "/students",method = RequestMethod.POST)
	@PostMapping("/students")
	public String create(@RequestBody Student student) {
		return "執行資料庫的create操作";
	}
	
	@GetMapping("/students/{studentId}")
	public String read(@PathVariable Integer studentId) {
		return "執行資料庫的read操作";
	}
	
	@PutMapping("/students/{studentId}")
	public String update(@PathVariable Integer studentId,
			             @RequestBody Student student) 
	{
		return "執行資料庫的update操作";
	}
	
	@DeleteMapping("/students/{studentId}")
	public String delete(@PathVariable Integer studentId) {
		return "執行資料庫的delete操作";
	}
	
}