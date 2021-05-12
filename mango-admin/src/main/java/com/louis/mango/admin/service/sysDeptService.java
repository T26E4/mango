package com.louis.mango.admin.service;

import java.util.List;

import com.louis.mango.admin.obj.dao.SysDept;
import com.louis.mango.core.service.CurdService;

public interface sysDeptService extends CurdService<SysDept>{

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
