package com.louis.mango.admin.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtAuthenicationFilter extends BasicAuthenticationFilter{

	public JwtAuthenicationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

}
