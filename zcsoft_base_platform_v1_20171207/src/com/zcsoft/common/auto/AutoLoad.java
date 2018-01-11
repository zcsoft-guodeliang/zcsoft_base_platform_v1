package com.zcsoft.common.auto;

import com.zcsoft.common.utils.CacheManager;
import com.zcsoft.common.utils.SpringBeanUtil;
import com.zcsoft.service.config.ISysConfigService;

public class AutoLoad {
	private static ISysConfigService configService=null;
	public void init() {
		try {
			System.out.println("初始化系统相关数据开始。。。。。。");
			configService = (ISysConfigService) SpringBeanUtil.getAppContext()
					.getBean("configService");
			CacheManager.getInstance();
			CacheManager.put("configCache", "configCache", configService.getSysConfigByName("customName"));
			System.out.println("初始化系统相关数据结束。。。。。。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
	}
}
