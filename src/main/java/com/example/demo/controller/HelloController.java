package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@RestController

public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/")
	public String hello() {
		
		return "hello world";
	}
	
	@GetMapping("/getStudent")
	public Student student() {
		Student stu = new Student();
		stu.setId(1);
		stu.setName("ball");
		stu.setDesc("yipintsoi");
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
		        .getRequest();

		String ip = request.getRemoteAddr();
		
		logger.info(ip + " get student");
		
		return stu;
	}
	
}
