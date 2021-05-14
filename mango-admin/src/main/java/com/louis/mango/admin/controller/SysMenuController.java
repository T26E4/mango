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

import com.louis.mango.admin.obj.dao.SysMenu;
import com.louis.mango.admin.service.SysMenuService;
import com.louis.mango.core.http.HttpResult;

@RestController
@RequestMapping("menu")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	
	@PostMapping(value="/save")
	@PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
	public HttpResult save(@RequestBody SysMenu record) {
		return HttpResult.ok(sysMenuService.save(record));
	}
	
	@PostMapping(value="/delete")
	@PreAuthorize("hasAuthority('sys:menu:delete')")
	public HttpResult delete(@RequestBody List<SysMenu> records) {
		return HttpResult.ok(sysMenuService.delete(records));
	}
	
	@GetMapping(value="/findNavTree")
	@PreAuthorize("hasAuthority('sys:menu:view')")
	public HttpResult findNavTree(@RequestParam String userName) {
		return HttpResult.ok(sysMenuService.findTree(userName, 1));
	}
	
	@GetMapping(value="/findMenuTree")
	@PreAuthorize("hasAuthority('sys:menu:view')")
	public HttpResult findMenuTree() {
		return HttpResult.ok(sysMenuService.findTree(null, 0));
	}
}
