package com.zcsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.github.pagehelper.Page;
import com.zcsoft.common.utils.BaseParameter;
import com.zcsoft.common.utils.JsonResult;
/**
 * 基础controller
 * BaseController
 * 2017年11月27日 上午10:11:37
 * @version 1.0.0
 */
public class BaseController {
	/**
	 * 错误代码
	 */
	public static String ERROR="-1";
	/**
	 * 成功代码
	 */
	public static String SUCCESS="0";
	public void PageModel(HttpServletRequest request, Page<?> page, Object obj)
			throws Exception {
		request.setAttribute("page", page);
		if(null!=page){
			request.setAttribute("pageNumber", page.getPageNum());
			request.setAttribute("pageSize", page.getPageSize());
			request.setAttribute("total", page.getTotal());
			request.setAttribute("pages", page.getPages());
		}
		request.setAttribute("obj", obj);

	}
	/**
	 * returnJsonResult 
	 *返回json对象
	 * @param code
	 * @param data
	 * @param errMsg
	 * @return
	 * @throws Exception 
	 *JsonResult
	 * @exception 
	 * @since  1.0.0
	 */
	 public JsonResult returnJsonResult(int code,Object data,String errMsg){
		 JsonResult result=new JsonResult();
		 result.setCode(code);
		 result.setData(data);
		 result.setErrMsg(errMsg);
		 return result;
	 }
	 
	 public Object getLoginID(){
		 Subject subject = SecurityUtils.getSubject();
		 Session session = subject.getSession(); 
		 return session.getAttribute(BaseParameter.LOGINID);
	 }
	
}
