package com.louis.mango.admin.service;

import java.util.List;

import com.louis.mango.admin.obj.dao.SysDict;
import com.louis.mango.core.service.CurdService;

/**
 * 字典管理
 * @author LiuTong
 *
 */
public interface SysDictService  extends CurdService<SysDict>{
	
	/**
	 * 根据名称查询
	 * @param label
	 * @return
	 */
	List<SysDict> findByLabel(String label);
}
