package com.example.demo;


import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Around("execution (* com.example.demo.HpPrinter.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Date start = new Date();
		Object obj = pjp.proceed();
		Date end = new Date();
		long time = end.getTime() - start.getTime();
		System.out.println("總共執行了：" + time + "ms");
		return obj;
	}
}
