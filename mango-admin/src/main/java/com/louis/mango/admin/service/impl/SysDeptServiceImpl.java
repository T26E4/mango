package com.louis.mango.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.louis.mango.admin.obj.dao.SysDept;
import com.louis.mango.admin.service.sysDeptService;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;

@Service
public class SysDeptServiceImpl implements sysDeptService{

	@Override
	public int save(SysDept record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SysDept record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<SysDept> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysDept findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult findPage(PageRequest pagetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
