package com.louis.mango.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louis.mango.admin.obj.dao.SysUser;
import com.louis.mango.admin.service.SysUserService;

@RestController
@RequestMapping("user")
public class SysUserController {

	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/findAll")
	public List<SysUser> findAll() {
		return sysUserService.findAll();
	}
}
