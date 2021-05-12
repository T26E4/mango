package com.louis.mango.admin.service;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.louis.mango.admin.obj.dao.SysUser;
import com.louis.mango.admin.obj.dao.SysUserRole;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.service.CurdService;

public interface SysUserService  extends CurdService<SysUser>{

	SysUser findByName(String username);

	/**
	 * 查找用户的菜单权限标识集合
	 * @param userName
	 * @return
	 */
	Set<String> findPermissions(String userName);

	/**
	 * 查找用户的角色集合
	 * @param userName
	 * @return
	 */
	List<SysUserRole> findUserRoles(Long userId);
	
	/**
	 * 生成用户信息excel
	 * @param pageRequest
	 * @return
	 */
	File createUserExcelFile(PageRequest pageRequest);
}
