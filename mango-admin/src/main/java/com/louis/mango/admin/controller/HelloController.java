package com.louis.mango.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping("/test")
	public String hello() {
		return "this is my first test demo";
	}
	
	@RequestMapping("/a")
	public String c() {
		return new A(3,"ddddd","ggggg").toString();
	}
}

class A{
	String aString;
	String cString;
	String w;
	int a;
	A(int a,String b,String c){
		this.a = a;
		this.aString =b;
		this.cString = c;
	}
}