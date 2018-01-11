package com.zcsoft.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
/**
* @ClassName: URLInterceptor 
* @Description: URL请求拦截器
* @author guodl
* @date 2017年9月9日 
*
 */
public class URLInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3)
			throws Exception {

	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String URL =request.getRequestURI()+"?";
		Enumeration<String> keys =request.getParameterNames(); 
		int count=0;
		request.setCharacterEncoding("UTF-8");  
		while(keys.hasMoreElements()) { 
			String k = keys.nextElement();
			System.out.println(request.getParameter(k));
			if(!StringUtils.isEmpty(request.getParameter(k))&&!"pageNum".equals(k)){
					if(count==0) URL+=k+"="+request.getParameter(k);
					else URL=URL+"&&"+k+"="+request.getParameter(k);
				    count++;
			}
		} 
		request.setAttribute("URL",URL.substring(1, URL.length()));
	 return true;
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		
	//	System.out.println("进入after。。。。。。。。。。。。。。。。");

	}

}