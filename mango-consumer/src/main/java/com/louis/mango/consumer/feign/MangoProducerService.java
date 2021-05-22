package com.louis.mango.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "mango-producer")
public interface MangoProducerService {

	@RequestMapping("/test/hello")
	public String hello();
}
