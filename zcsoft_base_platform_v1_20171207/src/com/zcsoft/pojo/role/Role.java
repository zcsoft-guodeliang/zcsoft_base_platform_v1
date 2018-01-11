package com.zcsoft.pojo.role;

import java.util.List;

import com.zcsoft.pojo.permission.SysPermission;

/**
 * Role 2017年12月5日 下午6:10:11 角色实体类
 * 
 * @version 1.0.0
 *
 */
public class Role {
	/**
	 * 主键Id
	 */
	private String id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 是否可用 0：可用 1：不可用
	 */
	private String available;
	/**
	 * 菜单id集合
	 */
	private String menuoids;
	/**
	 * 菜单集合
	 */
	private List<SysPermission> permissions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getMenuoids() {
		return menuoids;
	}

	public void setMenuoids(String menuoids) {
		this.menuoids = menuoids;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

}
