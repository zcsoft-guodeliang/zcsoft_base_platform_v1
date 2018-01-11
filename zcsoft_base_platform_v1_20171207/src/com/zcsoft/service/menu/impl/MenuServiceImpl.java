package com.zcsoft.service.menu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zcsoft.common.exception.CustomException;
import com.zcsoft.common.utils.CommonUtils;
import com.zcsoft.mapper.permission.SysPermissionMapper;
import com.zcsoft.pojo.Ztree;
import com.zcsoft.pojo.permission.SysPermission;
import com.zcsoft.service.menu.IMenuService;
/**
 * 菜单操作相关service
 * MenuServiceImpl
 * 2017年11月27日 上午9:33:08
 * @version 1.0.0
 */
public class MenuServiceImpl implements IMenuService {
	@Autowired
	private SysPermissionMapper permissionMapper;
	/**
	 * queryMenuPage 
	 * 查询菜单
	 * @param permission
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception 
	 *Page<SysPermission>
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public Page<SysPermission> queryMenuPage(SysPermission permission, Integer pageNum,
			Integer pageSize)
			throws Exception {
		permission.setAvailable("0");
		if (null !=  permission.getName() && !"".equals(permission.getName()))
			permission.setName(CommonUtils.decode(permission.getName()));
		PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize);
		return (Page<SysPermission>)permissionMapper.findMenuPage(permission);
	}
	/**
	 * querySysPermissionTreeList 
	 * 菜单树
	 * @param permission
	 * @return
	 * @throws Exception 
	 *List<Ztree>
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public List<Ztree> querySysPermissionTreeList(SysPermission permission)
			throws Exception {
		permission=new SysPermission();
		permission.setAvailable("0");
		return permissionMapper.findSysPermissionTreeList(permission);
	}
	/**
	 * saveSysPermission 
	 *保存菜单
	 * @param permission
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public void saveSysPermission(SysPermission permission) throws Exception {
		if (null == permission)
			throw new Exception("菜单表单数据不能为空");
		if (null == permission.getName() || "".equals(permission.getName()))
			throw new Exception("菜单名称不能为空");
		if (null == permission.getType() || "".equals(permission.getType()))
			throw new Exception("菜单类型不能为空");
		if (!"-1".equals(permission.getParentid())){
			if (null == permission.getUrl() || "".equals(permission.getUrl()))
				throw new Exception("菜单url不能为空");
			if(null==permission.getPercode() || "".equals(permission.getPercode()))
				throw new Exception("菜单代码不能为空");
		}
		permission.setAvailable("0");
		permissionMapper.insertsysPermission(permission); 
	}
	/**
	 * getSysPermissionById 
	 *根据id查询菜单权限
	 * @param id
	 * @return
	 * @throws Exception 
	 *SysPermission
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public SysPermission getSysPermissionById(String id) throws Exception {
		 if(null==id || "".equals(id))
			  throw new Exception("参数ID不能为空");
		 SysPermission permission= permissionMapper.findSysPermissionById(id);
		  if(null==permission)
			  throw new Exception("ID为:"+id+"菜单或权限按钮不存在");
		return permission;
	}
	/**
	 * updateSysPermission 
	 * 修改菜单
	 * @param permission
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public void updateSysPermission(SysPermission permission) throws Exception {
		if (null == permission)
			throw new Exception("菜单表单数据不能为空");
		if (null == permission.getId() || "".equals(permission.getId()))
			throw new Exception("菜单ID不能为空");
		if (null == permission.getName() || "".equals(permission.getName()))
			throw new Exception("菜单名称不能为空");
		if (null == permission.getType() || "".equals(permission.getType()))
			throw new Exception("菜单类型不能为空");
		if (!"-1".equals(permission.getParentid())) {
			if (null == permission.getUrl() || "".equals(permission.getUrl()))
				throw new Exception("菜单url不能为空");
			if (null == permission.getPercode()
					|| "".equals(permission.getPercode()))
				throw new Exception("菜单代码不能为空");
			SysPermission temp=permissionMapper.findSysPermissionById(permission.getId());
			if(null==temp)
				throw new Exception("未查询到ID为:"+permission.getId()+"的对象");
			permissionMapper.updateSysPermission(permission); 
		}
	}
	/**
	 * delSysPermissionById 
	 * 删除菜单或全新按钮
	 * @param id
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public void delSysPermissionById(String id) throws Exception {
		if (null ==id || "".equals(id))
			throw new Exception("菜单ID不能为空");
		SysPermission temp=permissionMapper.findSysPermissionById(id);
		if(null==temp)
			throw new Exception("未查询到ID为:"+id+"的对象");
		temp.setAvailable("1");
		permissionMapper.updateSysPermission(temp);
	}
}
