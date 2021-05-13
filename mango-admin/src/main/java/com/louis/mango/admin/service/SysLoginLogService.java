package com.louis.mango.admin.service;

import com.louis.mango.admin.obj.dao.SysLoginLog;
import com.louis.mango.core.service.CurdService;

public interface SysLoginLogService extends CurdService<SysLoginLog>{
	/**
	 * 记录登录日志
	 * @param userName
	 * @param ip
	 * @return
	 */
	int writeLoginLog(String userName, String ip);
}
