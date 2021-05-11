package com.louis.mango.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.mango.admin.obj.dao.SysUser;
import com.louis.mango.admin.obj.mapperdao.SysUserMapper;
import com.louis.mango.admin.service.SysUserService;
import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysusermapper;
	@Override
	public List<SysUser> findAll() {
		return sysusermapper.findAll();
	}
	@Override
	public int save(SysUser record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(SysUser record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(List<SysUser> records) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public SysUser findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PageResult findPage(PageRequest pagetRequest) {
		return MybatisPageHelper.findPage(pagetRequest, sysusermapper);
	}

}
