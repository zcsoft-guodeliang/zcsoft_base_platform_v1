package com.zcsoft.mapper;

import com.zcsoft.pojo.SysConfig;

/**
 * SysConfigMapper
 * 2017年12月7日 下午2:05:47
 * 系统相关参数
 * @version 1.0.0
 *
 */
public interface SysConfigMapper {
	/**
	 * selectSysConfigByName 
	 * 根据name获取参数配置
	 * @param name
	 * @return
	 * @throws Exception 
	 *SysConfig
	 * @exception 
	 * @since  1.0.0
	 */
    public SysConfig selectSysConfigByName(String name)throws Exception;
    
}
