package com.example.demo;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer
//,InitializingBean
{
	private int count;
	
	@PostConstruct
	public void init() {
		count = 5;
	}
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		count = 20;
//	}
	@Override
	public void print(String message) {
		count--;
		System.out.println("HP印表機："    + message);
		System.out.println("剩餘使用次數：" + count);
	}
	

}
