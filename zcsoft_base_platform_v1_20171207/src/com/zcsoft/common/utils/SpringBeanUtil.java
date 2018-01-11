package com.zcsoft.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanUtil implements ApplicationContextAware{
	private static ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		SpringBeanUtil.appContext = appContext;
	}

	public static ApplicationContext getAppContext() {
		return SpringBeanUtil.appContext;
	}
}
