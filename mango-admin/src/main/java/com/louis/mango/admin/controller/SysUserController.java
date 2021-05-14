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

import com.louis.mango.admin.constant.SysConstants;
import com.louis.mango.admin.obj.dao.SysUser;
import com.louis.mango.admin.service.SysUserService;
import com.louis.mango.admin.util.PasswordUtils;
import com.louis.mango.admin.util.SecurityUtils;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;

@RestController
@RequestMapping("user")
public class SysUserController {

	@Autowired
	SysUserService sysUserService;
	
	@PostMapping(value="/save")
	@PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
	public HttpResult save(@RequestBody SysUser record) {
		SysUser user = sysUserService.findById(record.getId());
		if(user != null) {
			if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
				return HttpResult.error("超级管理员不允许修改!");
			}
		}
		if(record.getPassword() != null) {
			String salt = PasswordUtils.getSalt();
			if(user == null) {
				// 新增用户
				if(sysUserService.findByName(record.getName()) != null) {
					return HttpResult.error("用户名已存在!");
				}
				String password = PasswordUtils.encode(record.getPassword(), salt);
				record.setSalt(salt);
				record.setPassword(password);
			} else {
				// 修改用户, 且修改了密码
				if(!record.getPassword().equals(user.getPassword())) {
					String password = PasswordUtils.encode(record.getPassword(), salt);
					record.setSalt(salt);
					record.setPassword(password);
				}
			}
		}
		return HttpResult.ok(sysUserService.save(record));
	}
	
	@PostMapping(value="/delete")
	@PreAuthorize("hasAuthority('sys:user:delete')")
	public HttpResult delete(@RequestBody List<SysUser> records) {
		for(SysUser record:records) {
			SysUser sysUser = sysUserService.findById(record.getId());
			if(sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
				return HttpResult.error("超级管理员不允许删除!");
			}
		}
		return HttpResult.ok(sysUserService.delete(records));
	}
	
	@GetMapping(value="/findByName")
	@PreAuthorize("hasAuthority('sys:user:view')")
	public HttpResult findByUserName(@RequestParam String name) {
		return HttpResult.ok(sysUserService.findByName(name));
	}
	
	
	@GetMapping(value="/findPermissions")
	@PreAuthorize("hasAuthority('sys:user:view')")
	public HttpResult findPermissions(@RequestParam String name) {
		return HttpResult.ok(sysUserService.findPermissions(name));
	}
	
	
	@GetMapping(value="/findUserRoles")
	@PreAuthorize("hasAuthority('sys:user:view')")
	public HttpResult findUserRoles(@RequestParam Long userId) {
		return HttpResult.ok(sysUserService.findUserRoles(userId));
	}
	
	@RequestMapping("/findPage")
	@PreAuthorize("hasAuthority('sys:user:view')")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysUserService.findPage(pageRequest));
	}
	
	@PostMapping(value="/exportUserExcelFile")
	@PreAuthorize("hasAuthority('sys:user:view')")
	public HttpResult exportUserExcelFile(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysUserService.createUserExcelFile(pageRequest));
	}
	
	@GetMapping(value="/updatePassword")
	@PreAuthorize("hasAuthority('sys:user:edit')")
	public HttpResult updatePassword(@RequestParam String password, @RequestParam String newPassword) {
		SysUser user = sysUserService.findByName(SecurityUtils.getUsername());
		if(user == null) {
			HttpResult.error("用户不存在!");
		}
		if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
			return HttpResult.error("超级管理员不允许修改!");
		}
		if(!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("原密码不正确!");
		}
		user.setPassword(PasswordUtils.encode(newPassword, user.getSalt()));
		return HttpResult.ok(sysUserService.save(user));
	}
}
