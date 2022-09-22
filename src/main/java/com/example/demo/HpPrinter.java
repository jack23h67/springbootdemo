package com.example.demo;

import org.springframework.stereotype.Component;


public class HpPrinter implements Printer{
	@Override
	public void print(String message) {
		System.out.println("HP印表機"+message);
	}

}
