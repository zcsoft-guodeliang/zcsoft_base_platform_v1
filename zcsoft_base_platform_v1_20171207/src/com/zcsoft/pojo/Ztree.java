package com.zcsoft.pojo;

public class Ztree {
	private String id;
	private String pId;
	private String name;
	private String checked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "Ztree [id=" + id + ", pId=" + pId + ", name=" + name
				+ ", checked=" + checked + "]";
	}

}
