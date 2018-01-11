package com.zcsoft.service.role.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zcsoft.mapper.role.SysRoleMapper;
import com.zcsoft.pojo.Ztree;
import com.zcsoft.pojo.role.Role;
import com.zcsoft.pojo.role.RolePermission;
import com.zcsoft.service.role.IRoleService;
import com.zcsoft.shiro.realm.CustomRealm;
/**
 * 角色相关service
 * RoleService
 * 2017年12月5日 下午6:47:27
 * @version 1.0.0
 *
 */
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private SysRoleMapper roleMapper;
	@Autowired
	private CustomRealm customRealm;
	/**
	 * querySysRoleTreeList 角色树
	 * @return
	 * @throws Exception 
	 *List<Ztree>
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public List<Ztree> querySysRoleTreeList() throws Exception {
		return roleMapper.selectRoleTreeList();
	}
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
	@Override
	public Page<Role> queryRolePage(Role role, Integer pageNum,
			int pageSize) throws Exception {
		PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize);
		return (Page<Role>)roleMapper.selectRolePage(role);
	}
	/**
	 * saveSysRoleAndRolePermission 
	 * 保存角色和菜单与角色关联
	 * @param role
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public void saveSysRoleAndRolePermission(Role role) throws Exception {
		customRealm.clearCached();//清空shiro缓存
		if (null == role)
			throw new Exception("角色表单数据不能为空");
		if (null == role.getName() || "".equals(role.getName()))
			throw new Exception("角色名称不能为空");
        roleMapper.insertSysRole(role);
        if(null!=role.getMenuoids() && !"".equals(role.getMenuoids())){
        	String[]  menuoids=role.getMenuoids().split(",");
        	List<RolePermission> rps=new ArrayList<RolePermission>();
        	RolePermission rp=null;
        	for(String id:menuoids){
        		rp=new RolePermission();
        		rp.setId(UUID.randomUUID().toString());
        		rp.setPermissionId(id);
        		rp.setRoleId(role.getId());
        		rps.add(rp);
        	}
        	roleMapper.insertSysRolePermissionBatch(rps);
        }
	}
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
	@Override
	public Role getRoleById(String roleId) throws Exception {
		 if(null==roleId || "".equals(roleId))
			  throw new Exception("角色ID不能为空");
		return roleMapper.selectSysRoleById(roleId);
	}
	/**
	 * modifyRoleAndRolePermission 
	 *修改角色和菜单关联
	 * @param role
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public void modifyRoleAndRolePermission(Role role) throws Exception {
		customRealm.clearCached();//清空shiro缓存
		if (null == role)
			throw new Exception("角色表单数据不能为空");
		if (null == role.getName() || "".equals(role.getName()))
			throw new Exception("角色名称不能为空");
        roleMapper.updateSysRole(role);
        roleMapper.deleteSysRolePermissionByRoleId(role.getId());
        if(null!=role.getMenuoids() && !"".equals(role.getMenuoids())){
        	String[]  menuoids=role.getMenuoids().split(",");
        	List<RolePermission> rps=new ArrayList<RolePermission>();
        	RolePermission rp=null;
        	for(String id:menuoids){
        		rp=new RolePermission();
        		rp.setId(UUID.randomUUID().toString());
        		rp.setPermissionId(id);
        		rp.setRoleId(role.getId());
        		rps.add(rp);
        	}
        	roleMapper.insertSysRolePermissionBatch(rps);
        }
	}
	/**
	 * modifyRoleAndRolePermissionByRoleId 
	 * 根据角色id修改用户角色和菜单关联
	 * @param roleId
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public void modifyRoleAndRolePermissionByRoleId(String roleId) throws Exception {
		customRealm.clearCached();//清空shiro缓存
		  if(null==roleId || "".equals(roleId))
			  throw new Exception("角色ID不能为空");
		  Role role=roleMapper.selectSysRoleById(roleId);
		  if(null==role)
			  throw new Exception("未查询到ID为:"+roleId+"的数据");
		  roleMapper.deleteSysRolePermissionByRoleId(role.getId());
		  roleMapper.updateSysRoleById(roleId);
	}
	
	
}
