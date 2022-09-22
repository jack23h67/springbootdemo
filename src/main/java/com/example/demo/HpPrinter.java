package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer
//,InitializingBean
{
	@Value("${printer.name}")
	private String name;
	@Value("${printer.count:20}")
	private int count;
	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		count = 20;
//	}
	@Override
	public void print(String message) {
		count--;
		System.out.println(name + ": " + message);
		System.out.println("剩餘使用次數：" + count);
	}
	

}
