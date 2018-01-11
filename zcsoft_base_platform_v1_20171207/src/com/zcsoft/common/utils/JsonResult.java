package com.zcsoft.common.utils;

public class JsonResult {
	private int code; // 0:成功 ，-1:失败 
	private String errMsg;
	private Object data;
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrMsg() {
		return this.errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		if (data != null) {
			this.data = data;
		}
	}
 
}
