package com.louis.mango.consumer.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class MangoProducerHystrix implements MangoProducerService{

	@RequestMapping("/test/hello")
	public String hello() {
		return "服务调用失败，返回的是hystrix的降级服务";
	}

	
}
