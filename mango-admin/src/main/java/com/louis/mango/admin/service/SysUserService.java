package com.louis.mango.admin.service;

import java.util.List;

import com.louis.mango.admin.obj.dao.SysUser;

public interface SysUserService {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<SysUser> findAll();
}
