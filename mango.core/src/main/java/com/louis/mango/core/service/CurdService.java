package com.louis.mango.core.service;

import java.util.List;

import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;

/**
 * 对通用增删改查接口的封装，统一定义了包含保存、删除、批量删除、
 * 根据ID查询和分页查询方法，一般的业务service接口会继承此接口，提供
 * 基础增删改查服务，这几个接口能满足大部分基础CURD业务的需求
 * @author LiuTong
 *
 */
public interface CurdService<T> {

	/**
	 * 保存操作
	 * @param record
	 * @return
	 */
	int save(T record);
	
	/**
	 * 删除接口
	 * @param record
	 * @return
	 */
	int delete(T record);
	
	
	/**
	 * 批量删除接口
	 * @param records
	 * @return
	 */
	int delete(List<T> records);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	T findById(Long id);
	
	/**
	 * 分页查询
	 * @param pagetRequest
	 * @return
	 */
	PageResult findPage(PageRequest pagetRequest);
}
