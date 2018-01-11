package com.zcsoft.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zcsoft.common.exception.CustomException;
import com.zcsoft.utils.CommonUtils;
import com.zcsoft.utils.RSAUtils;

 /**
 * pc端登陆
 * LoginController
 * 2017年11月20日 下午1:12:10
 * @version 1.0.0
 *
 */
@Controller
public class LoginController {
	/**
	 * login 
	 * 用户登录 
	 * @param request
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request) throws Exception{
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//先判断注册码是否已经过期
			// 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
			String exceptionClassName = (String) request
					.getAttribute("shiroLoginFailure");
			// 根据shiro返回的异常类路径判断，抛出指定异常信息
			if (exceptionClassName != null) {
				if (UnknownAccountException.class.getName().equals(
						exceptionClassName)) {
					// 最终会抛给异常处理器
					throw new CustomException("账号不存在");
				} else if (IncorrectCredentialsException.class.getName()
						.equals(exceptionClassName)) {
					throw new CustomException("用户名/密码错误");
				} else {
					
					throw new Exception();// 最终在异常处理器生成未知错误
				}
			}
		 
		return "login";
	}
	
	 
}
