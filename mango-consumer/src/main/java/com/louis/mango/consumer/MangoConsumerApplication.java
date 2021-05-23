package com.louis.mango.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MangoConsumerApplication {
	public static void main(String args[]) {
		SpringApplication.run(MangoConsumerApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	//添加的这部分是服务监控，跟feign中的hystrix服务容错本身没有关系
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServletRegistrationBean(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		
		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		
		return registrationBean;
		
	}
	
}
