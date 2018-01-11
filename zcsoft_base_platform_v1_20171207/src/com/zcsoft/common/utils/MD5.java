package com.zcsoft.common.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5 {

	/**
	 * md5 Md5加密
	 * 
	 * @param str
	 * @param salt
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public static String md5(String str, String salt) {
		return new Md5Hash(str, salt, 1).toString();// 第一个参数为加密字符串 salt为盐 第三个参数是
													// 散列次数 相当于加密次数
	}
}
