package com.zcsoft.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.zcsoft.common.exception.CustomException;
import com.zcsoft.common.utils.BaseParameter;
import com.zcsoft.common.utils.CommonUtils;
import com.zcsoft.common.utils.FileUtils;
import com.zcsoft.common.utils.JsonResult;
import com.zcsoft.controller.BaseController;
import com.zcsoft.pojo.user.SysUser;
import com.zcsoft.service.user.IUserService;

/**
 * UserController 
 * 2017年12月5日 下午5:41:50 
 * 用户管理controller
 * @version 1.0.0
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {
	@Autowired
	private IUserService userService;

	/**
	 * pageQuery 用户管理分页查询
	 * 
	 * @param request
	 * @param permission
	 * @param pageNum
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "pageQuery")
	public String pageQuery(HttpServletRequest request, SysUser user,
			Integer pageNum) {
		try {
			Page<SysUser> page = userService.queryUserPage(user, pageNum,
					BaseParameter.MiddlePageSize);
			PageModel(request, page, user);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return "user/pageQuery";
	}

	/**
	 * add 用户添加
	 * 
	 * @param request
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "add")
	@RequiresPermissions("user:add")
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
		return "user/add";
	}

	/**
	 * 
	 * @Title: uploadHeaderPic
	 * @Description: 上传头像
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "uploadHeaderPic")
	public @ResponseBody JsonResult uploadHeaderPic(MultipartFile file,
			HttpServletRequest request) {
		String path = "";
		try {
			path = FileUtils.uploadFile("headPicDirPath", request, file,
					(String) getLoginID());
		} catch (Exception e) {
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, path, null);
	}

	/**
	 * @Title: add
	 * @Description:用户添加
	 * @param @param request
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "save", method = { RequestMethod.POST })
	@RequiresPermissions("user:save")
	public @ResponseBody JsonResult save(HttpServletRequest request,
			@RequestBody SysUser user) {
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}

	/**
	 * 
	 * checkUserCodeIsUse 检测当前用户名是否可用
	 * 
	 * @param request
	 * @param code
	 * @param oid
	 * @return JsonResult
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "checkUserCodeIsUse", method = { RequestMethod.GET })
	public @ResponseBody JsonResult checkUserCodeIsUse(
			HttpServletRequest request, String code, String oid) {
		try {
			int count = userService.getSysUserCountByCode(
					CommonUtils.decode(code), oid);
			if (count > 0)
				return returnJsonResult(-1, null, "用户名已存在");
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}

	/**
	 * modify 用户修改展示
	 * 
	 * @param request
	 * @param oid
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "modify", method = { RequestMethod.GET })
	@RequiresPermissions("user:modify")
	public String modify(HttpServletRequest request, String oid) {
		try {
			SysUser user = userService.getSysUserByOid(oid);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new CustomException(e.getMessage());
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
		}
		return "user/modify";
	}

	/**
	 * update 用户修改
	 * 
	 * @param request
	 * @param user
	 * @return JsonResult
	 * @exception
	 * @since 1.0.0
	 */
	@RequestMapping(value = "update", method = { RequestMethod.POST })
	@RequiresPermissions("user:modify")
	public @ResponseBody JsonResult update(HttpServletRequest request,
			@RequestBody SysUser user) {
		try {
			userService.modifySysUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}
	/**
	 * del 用户删除
	 * @param request
	 * @param user
	 * @return 
	 *JsonResult
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value = "del", method = { RequestMethod.GET })
	@RequiresPermissions("user:del")
	public @ResponseBody JsonResult del(HttpServletRequest request, String  oid) {
		try {
			userService.modifySysUserByUserId(oid);
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}
	
	
	
}
