package com.louis.mango.admin.config;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity   //开启sercurity
@EnableGlobalMethodSecurity(prePostEnabled = true)    //开启权限注解，如：   @PreAuthorize注解

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 使用自定义身份验证组件
//		auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 禁用csrf，由于使用的是JWT  所以不需要crsf
		http.cors().and().csrf().disable()
		.authorizeRequests()
		//跨域预检要求
		.antMatchers("/webjars/**").permitAll()
		//查看sql监控
		.antMatchers("/druid/**").permitAll()
		//首页和登录页面
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		//swagger
		.antMatchers("/swagger-ui.html").permitAll()
		.antMatchers("/swagger-resources/**").permitAll()
		.antMatchers("/v2/api-docs").permitAll()
		.antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
		//验证码
		.antMatchers("/captcha.jpg**").permitAll()
		//服务监控
		.antMatchers("/actuator/**").permitAll()
		//其他所有请求需要身份认证
		.anyRequest().authenticated();
		
		http.headers().frameOptions().disable();
		//退出登录
		http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
		//token验证过滤器
//		http.addFilterBefore(new JwtAuthenticationFiler(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
}
