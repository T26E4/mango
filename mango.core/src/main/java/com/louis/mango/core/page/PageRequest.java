package com.louis.mango.core.page;

import java.util.ArrayList;
import java.util.List;

public class PageRequest {

	/**
	 * 当前页码
	 */
	private int pageNum;
	
	/**
	 * 每页数量
	 */
	private int pageSize = 20;
	
	
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
	
	/**
	 * 查询参数
	 */
	private List<Param> params = new ArrayList<>();
	/**
	 * 查询参数值
	 * @param name 参数名称
	 * @return
	 */
	public String getParamValue(String name) {
		Param param = getParam(name);
		if(param != null) {
			return param.getValue();
		}
		return null;
	}
	
	/**
	 * 查询参数对象
	 * @param name 参数名称
	 * @return
	 */
	public Param getParam(String name) {
		for(Param param:this.params) {
			if(name != null && name.equals(param.getName())) {
				return param;
			}
		}
		return null;
	}

	public void setParams(List<Param> params) {
		this.params = params;
	}
	
}
