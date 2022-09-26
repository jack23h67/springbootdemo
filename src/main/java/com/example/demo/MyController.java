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

	@RequestMapping("/test1")
	public String test1() {
		System.out.println("執行 test1 方法");
		return "Hello test1";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		System.out.println("執行 test2 方法");
		return "Hello test2";
	}
	
	
	
	
}
