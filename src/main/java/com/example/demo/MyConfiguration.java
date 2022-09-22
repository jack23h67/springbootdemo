package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	@Bean
	public Printer myPrinter() {
		return new HpPrinter();
	}
	
	@Bean
	public Printer yourPrinter() {
		return new CanonPrinter();
	}
}
