package com.louis.mango.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louis.mango.admin.obj.dao.SysLoginLog;
import com.louis.mango.admin.service.SysLoginLogService;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;

@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {
	@Autowired
	private SysLoginLogService sysLoginLogService;

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
	}
	
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysLoginLog> records) {
		return HttpResult.ok(sysLoginLogService.delete(records));
	}
}
