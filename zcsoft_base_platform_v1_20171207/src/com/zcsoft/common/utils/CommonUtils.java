package com.zcsoft.common.utils;
/**
 * 
 * CommonUtils
 * 2017年12月5日 下午2:45:13
 * 公用工具类
 * @version 1.0.0
 *
 */
public class CommonUtils {

	public static String decode(String str) throws Exception {
		if (null != str && !"".equals(str))
			return java.net.URLDecoder.decode(str, "utf-8");
		return "";

	}
}
