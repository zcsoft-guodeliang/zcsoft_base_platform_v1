package com.zcsoft.mapper.user;

import java.util.List;

import com.zcsoft.pojo.user.SysUser;

public interface SysUserMapper {
	/**
	 * selectSysUserByCode 
	 * 根据用户名查询用户
	 * @param user
	 * @return
	 * @throws Exception 
	 *SysUser
	 * @exception 
	 * @since  1.0.0
	 */
	public SysUser selectSysUserByCode(SysUser user) throws Exception;
	
	/**
	 * selectSysUserPage 
	 * 用户查询分页
	 * @param user
	 * @return
	 * @throws Exception 
	 *SysUser
	 * @exception 
	 * @since  1.0.0
	 */
	public List<SysUser> selectSysUserPage(SysUser user) throws Exception;
	/**
	 * insertSysUser 保存用户
	 * @param user
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void insertSysUser(SysUser user) throws Exception;
	/**
	 * 
	 * selectSysUserByCodeAndOid 
	 * 根据id和账号查询用户
	 * @param user
	 * @return
	 * @throws Exception 
	 *int
	 * @exception 
	 * @since  1.0.0
	 */
	public int selectSysUserByCodeAndOid(SysUser user)throws Exception;
	/**
	 * selectSysUserByOId 
	 *根据用户id查询用户对象
	 * @param oid
	 * @return
	 * @throws Exception 
	 *SysUser
	 * @exception 
	 * @since  1.0.0
	 */
	public SysUser selectSysUserByOId(String oid)throws Exception;
	/**
	 * updateSysUser 
	 * 用户修改
	 * @param user
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateSysUser(SysUser user)throws Exception;
	/**
	 * updateSysUserByID 
	 *根据用户id修改或删除用户
	 * @param userid
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateSysUserByID(String userid)throws Exception;

}
