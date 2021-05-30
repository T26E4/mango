package com.louis.mango.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class MyFilter extends ZuulFilter{
	private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

	public boolean shouldFilter() {
		return true;//是否启用该filter
	}

	public Object run() throws ZuulException {
		//filter需要执行的具体操作
		RequestContext ctxContext = RequestContext.getCurrentContext();
		HttpServletRequest request = ctxContext.getRequest();
		String tokenString = request.getParameter("token");
		System.out.println(tokenString);
		
		if(tokenString == null) {
			ctxContext.setSendZuulResponse(false);
			ctxContext.setResponseStatusCode(401);
			try {
				ctxContext.getResponse().getWriter().write("there is no requested token");
			}catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			return null;
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";//定义falter类型  有pre  route  post  error
	}

	@Override
	public int filterOrder() {
		return 0;//定义filter的顺序  数字越小优先级越高
	}

}
