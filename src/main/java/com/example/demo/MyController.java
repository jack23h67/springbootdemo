package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


 
@RestController
public class MyController {

	@RequestMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");	
	}
	
	@RequestMapping("/test1")
	public String test1(@RequestParam Integer id,
			            @RequestParam(required=false) String  name,
			            @RequestParam(defaultValue="10") Integer age) {
		System.out.println("id:" + id);
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		return "Hello test1";	
	}
	
	@RequestMapping("/test2")
	public String test2(@RequestBody Student student) {
		System.out.println("student id:"   + student.getId());
		System.out.println("student name:" + student.getName());
		return "Hello test2";
	}
	
	
	@RequestMapping("/test3")
	public String test3(@RequestHeader(name = "header-info")  String info,
			            @RequestHeader(name = "Content-Type",
			                           defaultValue = "application/json") String contentType) {
		System.out.println("header-info: "  + info);
		System.out.println("Content-Type: " + contentType);
		return "Hello test3";
	}
	
	@RequestMapping("/test4/{id}/{name}")
	public String test4(@PathVariable Integer id,
			            @PathVariable String name) {
		System.out.println("path id: " + id);
		System.out.println("path name:" + name);
		return "Hello test4";
	}
}
