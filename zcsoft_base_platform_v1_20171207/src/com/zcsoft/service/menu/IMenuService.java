package com.zcsoft.service.menu;

import java.util.List;

import com.github.pagehelper.Page;
import com.zcsoft.pojo.Ztree;
import com.zcsoft.pojo.permission.SysPermission;
/**
 * 菜单操作相关service
 * IMenuService
 * 2017年11月27日 上午10:03:18
 * @version 1.0.0
 */
public interface IMenuService {
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
	public Page<SysPermission> queryMenuPage(SysPermission permission,Integer pageNum,
			Integer pageSize)throws Exception;
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
	public List<Ztree> querySysPermissionTreeList(SysPermission permission)throws Exception;
	/**
	 * saveSysPermission 
	 *保存菜单
	 * @param permission
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void saveSysPermission(SysPermission permission)throws Exception;
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
	public SysPermission getSysPermissionById(String id)throws Exception;
	/**
	 * updateSysPermission 
	 * 修改菜单或权限按钮
	 * @param permission
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateSysPermission(SysPermission permission)throws Exception;
	/**
	 * delSysPermissionById 
	 * 删除菜单或全新按钮
	 * @param id
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void delSysPermissionById(String id)throws Exception;
}
