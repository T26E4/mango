package com.louis.mango.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louis.mango.admin.obj.dao.SysDept;
import com.louis.mango.admin.service.sysDeptService;
import com.louis.mango.core.http.HttpResult;

@RestController
@RequestMapping("dept")
public class SysDeptController {

	@Autowired
	sysDeptService sysDeptService;
	
	@PostMapping("/save")
	public HttpResult save(@RequestBody SysDept sysDept) {
		return HttpResult.ok(sysDeptService.save(sysDept));
	}
	
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<SysDept> sysDepts) {
		return HttpResult.ok(sysDeptService.delete(sysDepts));
	}
	
	@GetMapping("/findTree")
	public HttpResult findTree() {
		return HttpResult.ok(sysDeptService.findTree());
	}
}
