package com.zcsoft.mapper.role;

import java.util.List;

import com.zcsoft.pojo.Ztree;
import com.zcsoft.pojo.role.Role;
import com.zcsoft.pojo.role.RolePermission;
import com.zcsoft.pojo.role.UserRole;

/**
 * SysRoleMapper
 * 2017年12月5日 下午6:21:28
 * 角色相关接口
 * @version 1.0.0
 *
 */
public interface SysRoleMapper {
	/**
	 * selectRolePage 
	 *分页查询角色
	 * @param role
	 * @return
	 * @throws Exception 
	 *List<Role>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Role> selectRolePage(Role role)throws Exception;
	
	/**
	 * selectRoleByUserId 
	 * 根据用户id查询该用户拥有角色集合
	 * @param userId
	 * @return
	 * @throws Exception 
	 *List<Role>
	 * @exception 
	 * @since  1.0.0
	 */
   public List<Role> selectRoleByUserId(String userId)throws Exception;
   /**
    * selectRoleTreeList 
    * 角色树
    * @return
    * @throws Exception 
    *List<Ztree>
    * @exception 
    * @since  1.0.0
    */
   public List<Ztree> selectRoleTreeList()throws Exception;
   /**
    * insertSysUserRolePermissionBatch 
    *批量插入用户和角色关联
    * @param userRoles
    * @throws Exception 
    *void
    * @exception 
    * @since  1.0.0
    */
   public void insertSysUserRolePermissionBatch(List<UserRole> userRoles)throws Exception;
	/**
	 * deleteSysUserRoleByUserId 
	 * 根据用户id删除用户和角色关联
	 * @param oid
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void deleteSysUserRoleByUserId(String oid)throws Exception;
	/**
	 * insertSysRole
	 * 保存角色
	 * @param role
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void insertSysRole(Role role)throws Exception;
	/**
	 * insertSysRolePermissionBatch
	 * 批量保存角色和菜单关联
	 * @param role
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void insertSysRolePermissionBatch(List<RolePermission> rp)throws Exception;
	/**
	 * selectSysRoleById 
	 * 根据id查询角色
	 * @param id
	 * @return
	 * @throws Exception 
	 *Role
	 * @exception 
	 * @since  1.0.0
	 */
	public Role selectSysRoleById(String id)throws Exception;
	/**
	 * selectSysRolePermissionByRoleId 
	 * 根据角色ID查询角色和菜单关联
	 * @param roleId
	 * @return
	 * @throws Exception 
	 *List<RolePermission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<RolePermission> selectSysRolePermissionByRoleId(String roleId)throws Exception;
	/**
	 * updateSysRole 
	 * 修改角色
	 * @param role
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateSysRole(Role role)throws Exception;
	/**
	 * deleteSysRolePermissionByRoleId 
	 * 根据角色id删除角色与菜单关联
	 * @param roleId
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void deleteSysRolePermissionByRoleId(String roleId)throws Exception;
	/**
	 * updateSysRoleById 
	 * 根据id修改角色
	 * @param roleId
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateSysRoleById(String roleId)throws Exception;
	
}
