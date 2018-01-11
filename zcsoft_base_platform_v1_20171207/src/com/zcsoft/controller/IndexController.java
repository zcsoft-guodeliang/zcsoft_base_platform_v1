package com.zcsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zcsoft.common.utils.BaseParameter;
import com.zcsoft.pojo.user.ActiveUser;

 

@Controller
public class IndexController  extends BaseController{
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) throws Exception{
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();  
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		session.setAttribute(BaseParameter.ACTIVEUSER, activeUser);
		session.setAttribute(BaseParameter.LOGINID, activeUser.getUserid());
		return "index";
	}
	@RequestMapping(value = "top", method = RequestMethod.GET)
	public String top(HttpServletRequest request) {
		return "public/top";
	}
	@RequestMapping(value = "left")
	public String left(HttpServletRequest request) {
		return "public/left";
	}

	@RequestMapping(value = "main")
	public String main(HttpServletRequest request) {
		try {
			Subject subject = SecurityUtils.getSubject();
			// 取身份信息
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            if(activeUser.getUserType().equals("1"))//管理员工作台
            	return "public/admin_desk"; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "public/putongyonghu_desk";
	}
}
