package com.louis.mango.producer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class controller {

	@RequestMapping("/hello")
	public String hello() {
		return "hello mango producer!我是实例2";
	}
}
