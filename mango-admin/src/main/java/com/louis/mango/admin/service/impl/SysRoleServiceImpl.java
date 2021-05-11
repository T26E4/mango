package com.louis.mango.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.louis.mango.admin.obj.dao.SysRole;
import com.louis.mango.admin.service.SysRoleService;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@PostMapping("/save")
	@Override
	public int save(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<SysRole> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysRole findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult findPage(PageRequest pagetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
