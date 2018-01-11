package com.zcsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcsoft.common.utils.JsonResult;
import com.zcsoft.pojo.SysConfig;
import com.zcsoft.pojo.SysRegister;
import com.zcsoft.service.config.ISysConfigService;
import com.zcsoft.utils.CommonUtils;
/**
 * SystemRegisterController
 * 2017年12月7日 下午1:27:52
 * 系统注册
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping(value="register")
public class SystemRegisterController extends BaseController{
	@Autowired
	private ISysConfigService configService;
    /**
     * index 
     * 系统注册
     * @param request
     * @return
     * @throws Exception 
     *String
     * @exception 
     * @since  1.0.0
     */
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request) throws Exception{
		String serial=CommonUtils.CpuSerial();
		request.setAttribute("serial", serial);
		SysConfig config=configService.getSysConfigByName("customName");
		request.setAttribute("config", config);
		return "register";
	}
	/**
	 * register 
	 * 系统注册
	 * @param request
	 * @param register
	 * @return 
	 *JsonResult
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value = "register", method = { RequestMethod.POST })
	public @ResponseBody JsonResult register(HttpServletRequest request,
			@RequestBody SysRegister register) {
		try {
			configService.doRegister(register,request.getServletContext().getRealPath("/"));
		} catch (Exception e) {
			e.printStackTrace();
			return returnJsonResult(-1, null, e.getMessage());
		}
		return returnJsonResult(0, null, null);
	}
}
