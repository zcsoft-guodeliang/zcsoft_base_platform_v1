package com.zcsoft.common.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件操作相关工具类
 * FileUtils
 * 2017年12月5日 下午6:53:57
 * @version 1.0.0
 */
public class FileUtils {
	/**
	 * 
	 * @Title: saveFile
	 * @Description: 保存文件
	 * @param @param pictureFile
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return File 返回类型
	 * @throws
	 */
	public static String uploadFile(String config, HttpServletRequest request,
			MultipartFile pictureFile, String userid) throws Exception {
		File file = null;
		String path = "";
		if (pictureFile != null) {
			String filepath = (String) PropertiesUtils.readConfigProperties("headPicDirPath", "files_config.properties", request);
			String originalFilename = pictureFile.getOriginalFilename();// 图片的原始名称
			String newFileName = UUID.randomUUID()
					+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
			path = filepath + "\\" + userid + "\\"
					+ new SimpleDateFormat("yyyyMMdd").format(new Date())
					+ "\\";
			File tempFile = new File(path);
			if (!tempFile.exists())
				tempFile.mkdirs();
			file = new File(path + newFileName);// 新文件
			pictureFile.transferTo(file);// 将内存中的文件写入磁盘
			path = path + newFileName;
		}
		return path;
	}
}
