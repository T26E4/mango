package com.louis.mango.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.mango.admin.obj.dao.SysUser;
import com.louis.mango.admin.obj.mapperdao.SysUserMapper;
import com.louis.mango.admin.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysusermapper;
	@Override
	public List<SysUser> findAll() {
		return sysusermapper.findAll();
	}

}
