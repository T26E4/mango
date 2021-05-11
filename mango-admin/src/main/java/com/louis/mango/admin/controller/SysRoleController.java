package com.louis.mango.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.mango.admin.obj.dao.SysRole;
import com.louis.mango.admin.service.SysRoleService;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;

@RestController
@RequestMapping("user")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	
	@PostMapping("/save")
	public HttpResult save(@RequestBody SysRole sysRole) {
		return HttpResult.ok(sysRoleService.save(sysRole));
	}
	
	@PostMapping(value = "/delete")
	public HttpResult delete(@RequestBody List<SysRole> sysRoles) {
		return HttpResult.ok(sysRoleService.delete(sysRoles));
	}
	
	@PostMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysRoleService.findPage(pageRequest));
	}
	
	@GetMapping("/findByName")
	public HttpResult findByName(@RequestParam String labelName) {
		return null;
	}
	
	@GetMapping("/findPermissions")
	public HttpResult findPermissions(@RequestParam String name) {
		return null;
	}
	
	@GetMapping("/findUserRoles")
	public HttpResult findUserRoles(@RequestParam Long userId){
		return null;
	}
}
