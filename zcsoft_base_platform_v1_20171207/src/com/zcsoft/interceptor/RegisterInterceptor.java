package com.zcsoft.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zcsoft.common.utils.BaseParameter;
import com.zcsoft.common.utils.CacheManager;
import com.zcsoft.common.utils.SpringBeanUtil;
import com.zcsoft.pojo.SysConfig;
import com.zcsoft.service.config.ISysConfigService;
import com.zcsoft.utils.CommonUtils;
import com.zcsoft.utils.RSAUtils;

public class RegisterInterceptor implements HandlerInterceptor{
 
	private static  ISysConfigService configService; 

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		 
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		 
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		byte[] decodedData = RSAUtils.decryptByPublicKey(CommonUtils
				.toByteArray(request.getServletContext().getRealPath("/")
						+ "\\license.dat"));
		String target = new String(decodedData,"utf-8");
		String[] strs = target.split(";");
		String serial = strs[0];
		String customName = strs[1];
		String timeEnd = strs[2];
		Date currentDate = new SimpleDateFormat("yyyy-MM-dd")
				.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		// if(currentDate.getTime()>)
		long endTime = Long.parseLong(timeEnd.split("timeEnd=")[1]);
		String tempSerial=CommonUtils.CpuSerial();
	 
		if(!serial.equals("serial="+tempSerial)){
			request.setAttribute("errMsg", "注册码错误：不合法的机器码");
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return  false;
		}
		//将客户信息放入缓存中
		SysConfig config=null;
	 
		 Object tempConfig=CacheManager.get(BaseParameter.CONFIGCACHE, BaseParameter.CONFIGCACHE);
		if(null!=tempConfig){//从缓存中取
			config= (SysConfig)tempConfig;
		}else{//数据库中查询
			configService=(ISysConfigService) SpringBeanUtil
					.getAppContext().getBean("configService");
			config=configService.getSysConfigByName("customName");
			CacheManager.put(BaseParameter.CONFIGCACHE, BaseParameter.CONFIGCACHE, config);
		}
		if(!customName.equals("customName="+config.getValue())){
			request.setAttribute("errMsg", "注册码错误：客户名称不正确");
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return  false;
		}
		
		if (currentDate.getTime()>=endTime) {
			request.setAttribute("errMsg", "注册码错误：注册码已过期");
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return  false;
		} 
		long between_days=(endTime-currentDate.getTime())/(1000*3600*24); 
		if(between_days<6)//注册码到期一周提醒
			request.getSession().setAttribute("outTimeMsg", "注册码还有"+between_days+"天到期,请联系软件厂商！");
		
		//request.setAttribute("errMsg", "注册码即将已过期");
		return true;
	}

}
