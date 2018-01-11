package com.zcsoft.common.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
/**
 * 操作属性文件相关的工具类
 * PropertiesUtils
 * 2017年12月5日 下午6:55:22
 * @version 1.0.0
 */
public class PropertiesUtils {
	/**
	 * 
	 * @Title: readConfigProperties
	 * @Description:读取config.properties文件
	 * @param @return 设定文件
	 * @return Object 返回类型
	 * @throws
	 */
	public static Object readConfigProperties(String key,String propertiesName,
			HttpServletRequest request) throws Exception {
		Properties prop = new Properties();
		InputStream inputStream = request.getServletContext()
				.getResourceAsStream("/WEB-INF/classes/"+propertiesName+"");
		prop.load(inputStream);
		return prop.get(key);
	}
}
