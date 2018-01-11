package com.zcsoft.mapper.permission;

import java.util.List;

import com.zcsoft.pojo.Ztree;
import com.zcsoft.pojo.permission.SysPermission;
import com.zcsoft.pojo.permission.SysPermissionUserCustom;
import com.zcsoft.pojo.user.ActiveUser;

public interface SysPermissionMapper {
	/**
	 * 
	 * findMenuListByUserId 
	 * 根据用户id查询菜单
	 * @param user
	 * @return
	 * @throws Exception 
	 *List<SysPermission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<SysPermission> findMenuListByUserId(ActiveUser user)
			throws Exception;

	/**
	 * findPermissionListByUserId 
	 *根据用户id查询权限url
	 * @param user
	 * @return
	 * @throws Exception 
	 *List<SysPermission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<SysPermission> findPermissionListByUserId(ActiveUser user)
			throws Exception;
	/**
	 * findMenuByUseroid 
	 *查询二级菜单
	 * @param custom
	 * @return
	 * @throws Exception 
	 *List<SysPermission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<SysPermission> findMenuByUseroid(SysPermissionUserCustom custom)throws Exception;
	
	/**
	 * findMenuPage 
	 *查询二级菜单
	 * @param custom
	 * @return
	 * @throws Exception 
	 *List<SysPermission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<SysPermission> findMenuPage(SysPermission permission)throws Exception;
	/**
	 * findSysPermissionTreeList 
	 * 用户菜单权限树
	 * @param permission
	 * @return
	 * @throws Exception 
	 *List<Ztree>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Ztree> findSysPermissionTreeList(SysPermission permission)throws Exception;
	/**
	 * insertsysPermission 
	 * 保存菜单和权限
	 * @param permission
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void insertsysPermission(SysPermission permission)throws Exception;
	/**
	 * findSysPermissionById 
	 * 根据id查询菜单权限对象
	 * @param id
	 * @return
	 * @throws Exception 
	 *SysPermission
	 * @exception 
	 * @since  1.0.0
	 */
	public SysPermission  findSysPermissionById(String id)throws Exception;
	/**
	 * updateSysPermission 
	 *菜单修改
	 * @param permission
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateSysPermission(SysPermission permission)throws Exception;
}
