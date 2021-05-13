package com.louis.mango.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 * @author LiuTong
 *
 */
public class GrantAuthorityImpl implements GrantedAuthority{
	private static final long serialVersionUID = 9167346197926904701L;
	private String authority;

	public GrantAuthorityImpl(String auString) {
		this.authority = auString;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		return this.authority;
	}

}
