package com.zcsoft.controller.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.zcsoft.common.exception.CustomException;
import com.zcsoft.common.utils.BaseParameter;
import com.zcsoft.common.utils.JsonResult;
import com.zcsoft.controller.BaseController;
import com.zcsoft.pojo.Ztree;
import com.zcsoft.pojo.role.Role;
import com.zcsoft.service.role.IRoleService;
/**
 * RoleController
 * 2017年12月5日 下午6:38:58
 * 用户角色相关
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping(value = "role")
public class RoleController extends BaseController {
	@Autowired
	private IRoleService roleService;
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
	@RequestMapping(value = "pageQuery")
	public String pageQuery(HttpServletRequest request, Role role,
			Integer pageNum) {
		try {
			System.out.println(System.getProperty("java.io.tmpdir"));
			Page<Role> page = roleService.queryRolePage(role, pageNum,
					BaseParameter.MiddlePageSize);
			PageModel(request, page, role);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return "role/pageQuery";
	}
	
	/**
	 * add 角色添加
	 * 
	 * @param request
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "add")
	@RequiresPermissions("role:add")
	public String add(HttpServletRequest request) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return "role/add";
	}

	/**
	 * save 保存角色
	 * @param request
	 * @param permission
	 * @return JsonResult
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "save", method = { RequestMethod.POST })
	@RequiresPermissions("role:save")
	public @ResponseBody JsonResult save(HttpServletRequest request,
			@RequestBody Role role) {
		try {
			roleService.saveSysRoleAndRolePermission(role);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}
	@RequestMapping(value = "modify")
	@RequiresPermissions("role:modify")
	public String modify(HttpServletRequest request,String roleId) {
		try {
		  Role role=roleService.getRoleById(roleId);
		  request.setAttribute("role", role);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return "role/modify";
	} 
	/**
	 * update 角色修改
	 * @param request
	 * @param user
	 * @return JsonResult
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "update", method = { RequestMethod.POST })
	@RequiresPermissions("role:modify")
	public @ResponseBody JsonResult update(HttpServletRequest request,
			@RequestBody Role role) {
		try {
			roleService.modifyRoleAndRolePermission(role);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}
	@RequestMapping(value = "del", method = { RequestMethod.GET })
	@RequiresPermissions("role:del")
	public @ResponseBody JsonResult del(HttpServletRequest request,String roleId) {
		try {
			roleService.modifyRoleAndRolePermissionByRoleId(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}
	
	 
	
	
	/**
	 * getSysRoleTreeList 
	 *角色树
	 * @param request
	 * @return 
	 *List<Ztree>
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value = "getSysRoleTreeList", method = { RequestMethod.GET })
	public @ResponseBody List<Ztree> getSysRoleTreeList(
			HttpServletRequest request) {
		List<Ztree> list = null;
		try {
			list = roleService.querySysRoleTreeList();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
}
