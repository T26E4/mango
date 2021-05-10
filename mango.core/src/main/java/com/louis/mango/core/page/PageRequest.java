package com.louis.mango.core.page;

import java.util.HashMap;
import java.util.Map;

public class PageRequest {

	/**
	 * 当前页码
	 */
	private int pageNum;
	
	/**
	 * 每页数量
	 */
	private int pageSize = 20;
	
	/**
	 * 查询参数
	 */
	private Map<String,Object> params = new HashMap<>();

	/**
	 * 添加参数
	 * @param name
	 * @param value
	 */
	public void putParam(String name,Object value) {
		params.put(name, value);
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	
}
