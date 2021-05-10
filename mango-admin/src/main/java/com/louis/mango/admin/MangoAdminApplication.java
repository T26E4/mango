package com.louis.mango.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//默认扫描启动类包及其子包，scanBasePackages不配置也可以
@SpringBootApplication(scanBasePackages = {"com.louis.mango"})
public class MangoAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangoAdminApplication.class, args);
	}

}
//swagger     /swagger-ui.html
//druid       /druid/login.html