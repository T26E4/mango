package com.louis.mango.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.mango.admin.obj.dao.SysConfig;
import com.louis.mango.admin.service.SysConfigService;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;

@RestController
@RequestMapping("config")
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;
	
	@PostMapping(value="/save")
	@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	public HttpResult save(@RequestBody SysConfig record) {
		return HttpResult.ok(sysConfigService.save(record));
	}
	
	@PostMapping(value="/delete")
	@PreAuthorize("hasAuthority('sys:config:delete')")
	public HttpResult delete(@RequestBody List<SysConfig> records) {
		return HttpResult.ok(sysConfigService.delete(records));
	}
	
	@PostMapping(value="/findPage")
	@PreAuthorize("hasAuthority('sys:config:view')")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysConfigService.findPage(pageRequest));
	}
	
	@GetMapping(value="/findByLable")
	@PreAuthorize("hasAuthority('sys:config:view')")
	public HttpResult findByLable(@RequestParam String lable) {
		return HttpResult.ok(sysConfigService.findByLable(lable));
	}
}
