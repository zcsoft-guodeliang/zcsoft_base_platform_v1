package com.zcsoft.service.config.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zcsoft.mapper.SysConfigMapper;
import com.zcsoft.pojo.SysConfig;
import com.zcsoft.pojo.SysRegister;
import com.zcsoft.service.config.ISysConfigService;
import com.zcsoft.utils.CommonUtils;

public class SysConfigServiceImpl implements ISysConfigService{
   @Autowired
   private SysConfigMapper configMaper;
   /**
	 * getSysConfigByName 
	 * 根据name获取参数值
	 * @param name
	 * @return
	 * @throws Exception 
	 *SysConfig
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public SysConfig getSysConfigByName(String name) throws Exception {
		if(null==name || "".equals(name))
			 throw new Exception("参数名称不能为空");
		return configMaper.selectSysConfigByName(name);
	}
		/**
	    * doRegister 
	    *注册
	    * @param register
	    * @throws Exception 
	    *void
	    * @exception 
	    * @since  1.0.0
	    */
	@Override
		public void doRegister(SysRegister register,String path) throws Exception {
			  if(null==register)
				   throw new Exception("注册表单数据不能为空");
			//注册
			  CommonUtils.byteArrayToFile(register.getRegisterCode(), path+"\\license.dat");
		}

}
