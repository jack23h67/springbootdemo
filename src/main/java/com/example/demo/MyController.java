package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 
@RestController
public class MyController {

	@RequestMapping("/product")
	public Store product() {
		Store store = new Store();
		List<String> pList = new ArrayList<String>();
		pList.add("蘋果");
		pList.add("橘子");
		store.setProductList(pList);
		return store;	
	}
	
	@RequestMapping("/user")
	public Student user() {
		Student student = new Student();
		student.setName("Judy");
		student.setId(1);
		return student;
	}
}
