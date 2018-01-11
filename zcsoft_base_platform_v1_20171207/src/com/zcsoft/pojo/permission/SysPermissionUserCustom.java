package com.zcsoft.pojo.permission;

import com.zcsoft.pojo.user.ActiveUser;

public class SysPermissionUserCustom extends ActiveUser {
	private String parentid;

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

}