package com.louis.mango.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.mango.admin.obj.dao.SysDict;
import com.louis.mango.admin.obj.mapperdao.SysDictMapper;
import com.louis.mango.admin.service.SysDictService;
import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;

@Service
public class SysDictServiceImpl implements SysDictService{

	@Autowired
	private SysDictMapper sysdictMapper;
	
	
	@Override
	public int save(SysDict record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysdictMapper.insertSelective(record);
		}else {
			return sysdictMapper.updateByPrimaryKey(record);
		}
	}

	@Override
	public int delete(SysDict record) {
		return sysdictMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysDict> records) {
		for(SysDict sysDict : records) {
			delete(sysDict);
		}
		
		return records.size();
	}

	@Override
	public SysDict findById(Long id) {
		return sysdictMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pagetRequest) {
		Object labelObject = pagetRequest.getParams().get("label");
		if(labelObject != null) {
			return MybatisPageHelper.findPage(pagetRequest,sysdictMapper,"findPageByLabel", labelObject);
		}
		return MybatisPageHelper.findPage(pagetRequest, sysdictMapper);
	}

	@Override
	public List<SysDict> findByLabel(String label) {
		return sysdictMapper.findByLabel(label);
	}

}
