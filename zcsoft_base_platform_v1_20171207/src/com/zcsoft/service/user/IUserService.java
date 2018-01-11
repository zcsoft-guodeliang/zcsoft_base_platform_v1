package com.zcsoft.service.user;

import java.util.List;

import com.github.pagehelper.Page;
import com.zcsoft.pojo.Ztree;
import com.zcsoft.pojo.permission.SysPermission;
import com.zcsoft.pojo.permission.SysPermissionUserCustom;
import com.zcsoft.pojo.user.ActiveUser;
import com.zcsoft.pojo.user.SysUser;

/**
 * 用户相关service IUserService 2017年11月20日 下午8:33:44
 * 
 * @version 1.0.0
 *
 */
public interface IUserService {
	/**
	 * getUserByCode 根据用户名查询用户
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 *             SysUser
	 * @exception
	 * @since 1.0.0
	 */
	public SysUser getUserByCode(String code) throws Exception;

	/**
	 * findMenuListByUserId 根据用户id查询菜单
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 *             List<SysPermission>
	 * @exception
	 * @since 1.0.0
	 */
	public List<SysPermission> findMenuListByUserId(ActiveUser user)
			throws Exception;

	/**
	 * findPermissionListByUserId 根据用户ID获取用户授权
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 *             List<SysPermission>
	 * @exception
	 * @since 1.0.0
	 */
	public List<SysPermission> findPermissionListByUserId(ActiveUser user)
			throws Exception;

	/**
	 * findMenuByUseroidAndParentId 查询二级菜单
	 * 
	 * @param custom
	 * @return
	 * @throws Exception
	 *             List<SysPermission>
	 * @exception
	 * @since 1.0.0
	 */
	public List<SysPermission> findMenuByUseroidAndParentId(ActiveUser user,
			String parentId) throws Exception;
	/**
	 * queryUserPage
	 *  用户查询分页
	 * @param user
	 * @param pageNum
	 * @param middlePageSize
	 * @return
	 * @throws Exception 
	 *Page<SysUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public Page<SysUser> queryUserPage(SysUser user, Integer pageNum,
			int middlePageSize) throws Exception;
	/**
	 * saveUser 保存用户
	 * @param user
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void saveUser(SysUser user)throws Exception;
   /**
    * getSysUserCountByCode 
    *检查用户名是否存在
    * @param decode
    * @param oid
    * @return
    * @throws Exception 
    *int
    * @exception 
    * @since  1.0.0
    */
	public int getSysUserCountByCode(String decode, String oid)throws Exception;
	/**
	 * getSysUserByOid 
	 *  修改用户展示
	 * @param oid
	 * @return
	 * @throws Exception 
	 *SysUser
	 * @exception 
	 * @since  1.0.0
	 */
    public SysUser getSysUserByOid(String oid)throws Exception;
    /**
     * modifySysUser 
     * 用户修改
     * @param user
     * @throws Exception 
     *void
     * @exception 
     * @since  1.0.0
     */
	public void modifySysUser(SysUser user)throws Exception;
	/**
	 * modifySysUserByUserId 
	 * 根据用户id修改或删除用户
	 * @param oid
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public void modifySysUserByUserId(String oid)throws Exception;
	
}
