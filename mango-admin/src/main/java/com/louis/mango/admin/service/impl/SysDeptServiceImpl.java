package com.louis.mango.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.mango.admin.obj.dao.SysDept;
import com.louis.mango.admin.obj.mapperdao.SysDeptMapper;
import com.louis.mango.admin.service.sysDeptService;
import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;

@Service
public class SysDeptServiceImpl implements sysDeptService{

	@Autowired
	private SysDeptMapper sysDeptMapper;

	@Override
	public int save(SysDept record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysDeptMapper.insertSelective(record);
		}
		return sysDeptMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysDept record) {
		return sysDeptMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysDept> records) {
		for(SysDept record:records) {
			delete(record);
		}
		return records.size();
	}

	@Override
	public SysDept findById(Long id) {
		return sysDeptMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysDeptMapper);
	}

	@Override
	public List<SysDept> findTree() {
		List<SysDept> sysDepts = new ArrayList<>();
		List<SysDept> depts = sysDeptMapper.findAll();
		for (SysDept dept : depts) {
			if (dept.getParentId() == null || dept.getParentId() == 0) {
				dept.setLevel(0);
				sysDepts.add(dept);
			}
		}
		findChildren(sysDepts, depts);
		return sysDepts;
	}

	private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
		for (SysDept sysDept : sysDepts) {
			List<SysDept> children = new ArrayList<>();
			for (SysDept dept : depts) {
				if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
					dept.setParentName(dept.getName());
					dept.setLevel(sysDept.getLevel() + 1);
					children.add(dept);
				}
			}
			sysDept.setChildren(children);
			findChildren(children, depts);
		}
	}

}
