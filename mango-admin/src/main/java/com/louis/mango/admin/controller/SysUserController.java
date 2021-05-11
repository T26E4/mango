package com.louis.mango.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louis.mango.admin.obj.dao.SysUser;
import com.louis.mango.admin.service.SysUserService;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;

@RestController
@RequestMapping("user")
public class SysUserController {

	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/findAll")
	public List<SysUser> findAll() {
		return sysUserService.findAll();
	}
	
	@RequestMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysUserService.findPage(pageRequest));
	}
}
