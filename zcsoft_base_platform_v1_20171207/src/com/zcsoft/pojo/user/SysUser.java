package com.zcsoft.pojo.user;

import java.util.Date;
import java.util.List;

import com.zcsoft.pojo.role.Role;

/**
 * 用户实体类 SysUser 2017年11月20日 下午1:35:06
 * 
 * @version 1.0.0
 */
public class SysUser {
	/** 主键 **/
	private String oid;
	/** 用户登录名 **/
	private String code;
	/** 用户名称 **/
	private String username;
	/** 密码 **/
	private String userpass;
	/** 用户类型 1-管理员 2-普通用户 3-其他 默认2 **/
	private String userType = "2";
	/** 性别 1-男 2-女 3-其他 默认1 **/
	private String userSex = "1";
	/** 联系电话 **/
	private String userTel;
	/** 邮箱 **/
	private String userEmail;
	/** 用户状态 1-有效 2-禁用 3-失效 默认1 **/
	private String delFlag = "1";
	/** 创建时间 **/
	private Date createDate = new Date();
	/** 更新时间 **/
	private Date updateDate = new Date();
	/** 排序号 **/
	private int orderNum;
	/** 微信oppenid **/
	private String openid;
	/** 扩展字段 **/
	private String ext1;
	/** 扩展字段 **/
	private String ext2;
	/** 扩展字段 **/
	private String ext3;
	private String headImg;// 头像id

	private String salt;// 盐
	
    private List<Role> roles;//用户所属角色
    
    /** 角色id集合 **/
	private String roleoids;
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getRoleoids() {
		return roleoids;
	}

	public void setRoleoids(String roleoids) {
		this.roleoids = roleoids;
	}

}
