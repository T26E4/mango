package com.louis.mango.admin.service;

import java.util.List;

import com.louis.mango.admin.obj.dao.SysConfig;
import com.louis.mango.core.service.CurdService;

public interface SysConfigService extends CurdService<SysConfig>{

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
