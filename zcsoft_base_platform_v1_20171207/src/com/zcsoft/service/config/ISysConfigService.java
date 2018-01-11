package com.zcsoft.service.config;

import com.zcsoft.pojo.SysConfig;
import com.zcsoft.pojo.SysRegister;

/**
 * ISysConfigService
 * 2017年12月7日 下午2:07:52
 * @version 1.0.0
 * 系统参数
 */
public interface ISysConfigService {
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
   public SysConfig getSysConfigByName(String name)throws Exception;
   /**
    * doRegister 
    *注册
    * @param register
    * @throws Exception 
    *void
    * @exception 
    * @since  1.0.0
    */
   public void  doRegister(SysRegister register,String path)throws Exception;
}
