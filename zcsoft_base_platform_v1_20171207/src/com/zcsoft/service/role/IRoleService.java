package com.zcsoft.service.role;

import java.util.List;

import com.github.pagehelper.Page;
import com.zcsoft.pojo.Ztree;
import com.zcsoft.pojo.role.Role;
import com.zcsoft.pojo.user.SysUser;
/**
 * 角色相关service
 * RoleService
 * 2017年12月5日 下午6:47:27
 * @version 1.0.0
 *
 */
public interface IRoleService {
	/**
	 * querySysRoleTreeList 角色树
	 * @return
	 * @throws Exception 
	 *List<Ztree>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Ztree> querySysRoleTreeList()throws Exception;
	/**
	 * pageQuery 
	 * 角色查询分页
	 * @param request
	 * @param role
	 * @param pageNum
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	 */
	public Page<Role> queryRolePage(Role role, Integer pageNum,
			int middlePageSize)throws Exception;
	/**
	 * 
	 * saveSysRoleAndRolePermission 
	 * 保存角色和菜单与角色关联
	 * @param role
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void saveSysRoleAndRolePermission(Role role)throws Exception;
	/**
	 * getRoleById 
	 *根据id获取角色
	 * @param roleId
	 * @return
	 * @throws Exception 
	 *Role
	 * @exception 
	 * @since  1.0.0
	 */
	public Role getRoleById(String roleId)throws Exception;
	/**
	 * modifyRoleAndRolePermission 
	 *修改角色和菜单关联
	 * @param role
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void modifyRoleAndRolePermission(Role role)throws Exception;
	/**
	 * modifyRoleAndRolePermissionByRoleId 
	 * 根据角色id修改用户角色和菜单关联
	 * @param roleId
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void modifyRoleAndRolePermissionByRoleId(String roleId)throws Exception;
}
