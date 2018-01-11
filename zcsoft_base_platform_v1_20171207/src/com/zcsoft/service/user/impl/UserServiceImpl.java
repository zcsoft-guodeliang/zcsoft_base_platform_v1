package com.zcsoft.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zcsoft.common.exception.CustomException;
import com.zcsoft.common.utils.CommonUtils;
import com.zcsoft.common.utils.MD5;
import com.zcsoft.mapper.permission.SysPermissionMapper;
import com.zcsoft.mapper.role.SysRoleMapper;
import com.zcsoft.mapper.user.SysUserMapper;
import com.zcsoft.pojo.permission.SysPermission;
import com.zcsoft.pojo.permission.SysPermissionUserCustom;
import com.zcsoft.pojo.role.UserRole;
import com.zcsoft.pojo.user.ActiveUser;
import com.zcsoft.pojo.user.SysUser;
import com.zcsoft.service.user.IUserService;
import com.zcsoft.shiro.realm.CustomRealm;
/**
 * 用户操作相关service
 * IUserService
 * 2017年11月20日 下午1:39:20
 * @version 1.0.0
 */
public class UserServiceImpl implements IUserService {
	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private SysPermissionMapper permissionMapper;
	@Autowired
	private SysRoleMapper roleMapper;
	@Autowired
	private CustomRealm customRealm;

	/**
	 * getUserByCode 
	 * 根据用户名查询用户 
	 * @param code
	 * @return
	 * @throws Exception 
	 * SysUser
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public SysUser getUserByCode(String code) throws Exception {
		if (StringUtils.isEmpty(code))
			throw new CustomException("登录账号不能为空");
		SysUser user = new SysUser();
		user.setCode(code);
		return userMapper.selectSysUserByCode(user);
	}
	 /**
	   * findMenuListByUserId 
	   * 根据用户id查询菜单
	   * @param user
	   * @return
	   * @throws Exception 
	   *List<SysPermission>
	   * @exception 
	   * @since  1.0.0
	   */
	@Override
	public List<SysPermission> findMenuListByUserId(ActiveUser user)
			throws Exception {
		return permissionMapper.findMenuListByUserId(user);
	}
	/**
	   * findPermissionListByUserId 
	   * 根据用户ID获取用户授权
	   * @param user
	   * @return
	   * @throws Exception 
	   *List<SysPermission>
	   * @exception 
	   * @since  1.0.0
	   */
	@Override
	public List<SysPermission> findPermissionListByUserId(ActiveUser user)
			throws Exception {
		
		return permissionMapper.findPermissionListByUserId(user);
	}
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
	@Override
	public List<SysPermission> findMenuByUseroidAndParentId(ActiveUser user,String parentId)
			throws Exception {
		if(null==user)
			throw new Exception("用户id不能为空");
		if(StringUtils.isEmpty(parentId))
			throw new Exception("菜单id不能为空");
		SysPermissionUserCustom custom=new SysPermissionUserCustom();
		custom.setUserid(user.getUserid());
		custom.setUsercode(user.getUsercode());
		custom.setParentid(parentId);
		return permissionMapper.findMenuByUseroid(custom);
	}
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
	@Override
	public Page<SysUser> queryUserPage(SysUser user, Integer pageNum,
			int pageSize) throws Exception {
		if (null != user.getUsername() && !"".equals(user.getUsername()))
			user.setUsername(CommonUtils.decode(user.getUsername()));
		if (null != user.getCode() && !"".equals(user.getCode()))
			user.setCode(CommonUtils.decode(user.getCode()));
		PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize);
		return (Page<SysUser>)userMapper.selectSysUserPage(user);
	}
	/**
	 * saveUser 保存用户
	 * @param user
	 * @throws Exception 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public void saveUser(SysUser user) throws Exception {
		customRealm.clearCached();//清空shiro缓存
		 if(null==user)
			  throw new Exception("用户保存表单数据不能为空");
		if(null==user.getUsername() || "".equals(user.getUsername()))
			throw new Exception("用户真实姓名不能为空");
		if(null==user.getCode() || "".equals(user.getCode()))
			throw new Exception("用户登录账号不能为空");
		if(null==user.getUserpass() || "".equals(user.getUserpass()))
			throw new Exception("用户密码不能为空");
		String salt=UUID.randomUUID().toString();
		user.setUserpass(MD5.md5(user.getUserpass(), salt));
		user.setSalt(salt);
		userMapper.insertSysUser(user);
		if (null != user.getRoleoids()
				&& !"".equals(user.getRoleoids())) {
			String[] roleids = user.getRoleoids().split(",");
			List<UserRole> uroles = new ArrayList<UserRole>();
			UserRole ur = null;
			for (int i = 0; i < roleids.length; i++) {
				if (!"0".equals(roleids[i])) {
					ur = new UserRole();
					ur.setId(UUID.randomUUID().toString());
					ur.setRoleid(roleids[i]);
					ur.setUserid(user.getOid());
					uroles.add(ur);
				}

			}
			roleMapper.insertSysUserRolePermissionBatch(uroles);
		}
	}
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
	@Override
	public int getSysUserCountByCode(String code, String oid)
			throws Exception {
		SysUser user = new SysUser();
		user.setOid(oid);
		user.setCode(code);
		return userMapper.selectSysUserByCodeAndOid(user);
	}
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
	@Override
	public SysUser getSysUserByOid(String oid) throws Exception {
		 if(null==oid || "".equals(oid))
			  throw new Exception("用户ID不能为空");
		return userMapper.selectSysUserByOId(oid);
	}
	 /**
     * modifySysUser 
     * 用户修改
     * @param user
     * @throws Exception 
     *void
     * @exception 
     * @since  1.0.0
     */
	@Override
	public void modifySysUser(SysUser user) throws Exception {
		customRealm.clearCached();//清空shiro缓存
		if (null == user)
			throw new Exception("用户表单数据不能为空");
		if (null == user.getOid() || "".equals(user.getOid()))
			throw new Exception("用户ID不能为空");
		if (null == user.getUsername() || "".equals(user.getUsername()))
			throw new Exception("用户真实姓名不能为空");
		if (null == user.getCode() || "".equals(user.getCode()))
			throw new Exception("用户登录账号不能为空");
          userMapper.updateSysUser(user);
          if (null != user.getRoleoids() && !"".equals(user.getRoleoids())) {
        	 roleMapper.deleteSysUserRoleByUserId(user.getOid());
  			String[] roleids = user.getRoleoids().split(",");
  			List<UserRole> uroles = new ArrayList<UserRole>();
  			UserRole ur = null;
			for (int i = 0; i < roleids.length; i++) {
				if (!"0".equals(roleids[i])) {
					ur = new UserRole();
					ur.setId(UUID.randomUUID().toString());
					ur.setRoleid(roleids[i]);
					ur.setUserid(user.getOid());
					uroles.add(ur);
				}
			}
			roleMapper.insertSysUserRolePermissionBatch(uroles);
  		}
	}
	/**
	 * modifySysUserByUserId 
	 * 根据用户id修改或删除用户
	 * @param oid
	 * @throws Exception 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public void modifySysUserByUserId(String oid) throws Exception {
		SysUser user = userMapper.selectSysUserByOId(oid);
		if (null == user)
			throw new Exception("当前操作的用户对象不存在");
		roleMapper.deleteSysUserRoleByUserId(oid);
		userMapper.updateSysUserByID(oid);
	}
}
