package com.louis.mango.admin.config;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
@EnableConfigurationProperties({DruidConfigProperties.class})
public class DruidConfig {

	@Autowired
	private DruidConfigProperties druidConfigProperties;
	
	@Bean
	@ConditionalOnMissingBean
	public DataSource druiDataSource() {
		//copy druid配置信息
		DruidDataSource druiDataSource = new DruidDataSource();
		BeanUtils.copyProperties(druidConfigProperties, druiDataSource);
		return druiDataSource;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public ServletRegistrationBean<Servlet> druidBean(){
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<Servlet>(new StatViewServlet(),"/druid/*");
		//白名单
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1,139.196.87.48");
		//ip黑名单(存在共同时，deny优先于allow）
		//如果满足deny的话提示：sorry you are not permitted to view this page
		servletRegistrationBean.addInitParameter("deny", "192.168.1.119");
		//登录查看信息的账号密码，用于登录druid监控后台
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "admin");
		//是否能够重置数据
		servletRegistrationBean.addInitParameter("resetEnable", "true");
		return servletRegistrationBean;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public FilterRegistrationBean<Filter> filterRegistrationBean(){
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.png,*.css,*.ico,/druid/*");
		
		return filterRegistrationBean;
	}
}
