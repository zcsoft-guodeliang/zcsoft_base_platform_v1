package com.zcsoft.common.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PicByPathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String imgPath = request.getParameter("path");
			ServletOutputStream outStream = response.getOutputStream();// 得到向客户端输出二进制数据的对象
			response.setDateHeader("Expires",
					System.currentTimeMillis() + 60 * 60 * 5000
					);// 缓存时间五小时
			FileInputStream fis = new FileInputStream(imgPath); // 以byte流的方式打开文件
			// 读数据
			byte data[] = new byte[1000];
			while (fis.read(data) > 0) {
				outStream.write(data);
			}
			fis.close();
			outStream.write(data); // 输出数据
			response.setContentType("image/*"); // 设置返回的文件类型
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
