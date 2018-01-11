package com.zcsoft.controller.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
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
import com.zcsoft.pojo.permission.SysPermission;
import com.zcsoft.pojo.user.ActiveUser;
import com.zcsoft.service.menu.IMenuService;
import com.zcsoft.service.user.IUserService;

/**
 * MenuController 2017年11月20日 下午8:59:23 菜单相关controller
 * 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController extends BaseController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IMenuService menuService;

	@RequestMapping(value = "getChildMenuJson", method = { RequestMethod.GET })
	public @ResponseBody List<SysPermission> getChildMenuJson(
			HttpServletRequest request, String menuPid) {
		List<SysPermission> list = null;
		try {
			// 查询下级菜单
			Subject subject = SecurityUtils.getSubject();
			// 取身份信息
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			list = userService
					.findMenuByUseroidAndParentId(activeUser, menuPid);
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

	/**
	 * query 查询菜单
	 * 
	 * @param request
	 * @param permission
	 * @param pageNum
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "pageQuery")
	public String pageQuery(HttpServletRequest request, SysPermission permission,
			Integer pageNum) {
		try {
			Page<SysPermission> page = menuService.queryMenuPage(permission,
					pageNum, BaseParameter.MiddlePageSize);
			PageModel(request, page, permission);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return "menu/pageQuery";
	}

	@RequestMapping(value = "getSysPermissionTree", method = { RequestMethod.GET })
	public @ResponseBody List<Ztree> getSysPermissionTree(
			HttpServletRequest request) {
		List<Ztree> list = null;
		try {
			list = menuService.querySysPermissionTreeList(null);
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

	/**
	 * add 菜单新增
	 * 
	 * @param request
	 * @param permission
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "add")
	@RequiresPermissions("menu:add")
	public String add(HttpServletRequest request, SysPermission permission) {
		try {
			List<Ztree> list = menuService.querySysPermissionTreeList(null);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return "menu/add";
	}

	/**
	 * save 保存菜单
	 * 
	 * @param request
	 * @param permission
	 * @return JsonResult
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "save", method = { RequestMethod.POST })
	@RequiresPermissions("menu:save")
	public @ResponseBody JsonResult save(HttpServletRequest request,
			@RequestBody SysPermission permission) {
		try {
			menuService.saveSysPermission(permission);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}

	/**
	 * modify 菜单修改展示
	 * 
	 * @param request
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "modify", method = { RequestMethod.GET })
	@RequiresPermissions("menu:modify")
	public String modify(HttpServletRequest request, String id) {
		try {
			List<Ztree> list = menuService.querySysPermissionTreeList(null);
			request.setAttribute("list", list);
			SysPermission permission = menuService.getSysPermissionById(id);
			request.setAttribute("permission", permission);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return "menu/modify";
	}

	/**
	 * update 修改菜单
	 * 
	 * @param request
	 * @param permission
	 * @return JsonResult
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "update", method = { RequestMethod.POST})
	@RequiresPermissions("menu:modify")
	public @ResponseBody JsonResult update(HttpServletRequest request,
			@RequestBody SysPermission permission) {
		try {
			menuService.updateSysPermission(permission);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}

	/**
	 * del 菜单删除
	 * 
	 * @param request
	 * @param id
	 * @return JsonResult
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "del", method = { RequestMethod.GET })
	@RequiresPermissions("menu:del")
	public @ResponseBody JsonResult del(HttpServletRequest request, String id) {
		try {
			menuService.delSysPermissionById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}

}
