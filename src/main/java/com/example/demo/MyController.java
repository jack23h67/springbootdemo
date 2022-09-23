package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


 
@RestController
public class MyController {

	@RequestMapping("/test1")
	public String test1(@RequestParam Integer id,
			            @RequestParam(required=false) String  name,
			            @RequestParam(defaultValue="10") Integer age) {
		System.out.println("id:" + id);
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		return "Hello test1";	
	}

}
