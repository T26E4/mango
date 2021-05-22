package com.louis.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonHelloController {

	@Autowired
	private RestTemplate  restTemplate;
	
	@RequestMapping("/ribbon/call")
	public String call() {
		//LoadBalanceInterceptor会拦截调用并分局服务名找到对应的服务
		String callServiceResult = restTemplate.getForObject("http://mango-producer/test/hello", String.class);
		
		return callServiceResult;
	}
	
}
