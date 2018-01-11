package com.zcsoft.pojo;

/**
 * SysRegister 2017年12月7日 下午2:20:32
 * 
 * @version 1.0.0 系统注册
 */
public class SysRegister {
	/**
	 * 机器服务码
	 */
	private String serviceCode;
	/**
	 * 客户名称
	 */
	private String customName;
	/**
	 * 注册码
	 */
	private String registerCode;

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

}
