package com.zcsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zcsoft.shiro.realm.CustomRealm;

 
@Controller
public class ClearShiroCache {
	
	//注入realm
	@Autowired
	private CustomRealm customRealm;
	
	@RequestMapping("/clearShiroCache")
	public String clearShiroCache(){
		
		//清除缓存，将来正常开发要在service调用customRealm.clearCached()
		customRealm.clearCached();
		
		return "success";
	}

}
