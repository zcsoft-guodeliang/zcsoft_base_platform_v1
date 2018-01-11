package com.zcsoft.pojo;

import java.io.Serializable;

/**
 * SysConfig 2017年12月7日 下午2:04:44
 * 
 * @version 1.0.0 系统基础配置参数
 */
public class SysConfig  implements Serializable{
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
