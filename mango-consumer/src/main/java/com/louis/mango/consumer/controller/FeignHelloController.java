package com.louis.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louis.mango.consumer.feign.MangoProducerService;

@RestController
public class FeignHelloController {

	@Autowired
	private MangoProducerService mangoProduerService;
	
	@RequestMapping("/feign/call")
	public String call() {
		return mangoProduerService.hello();
	}
}
