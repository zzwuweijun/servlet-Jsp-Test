package com.sz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sz.dao.impl.test;
import com.sz.pojo.User;
import com.sz.service.UserService;
import com.sz.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	//定义Logger对象
	static org.apache.log4j.Logger log =org.apache.log4j.Logger.getLogger(UserServlet.class); 

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求数据
		String oper = req.getParameter("oper");
		if (oper.equals("login")) {
			// 调用登录处理方法
			checkUserLogin(req, resp);
		} else if (oper.equals("reg")) {
			// 调用注册处理方法

		} else {
			log.info("失败，用户没有选择相应的操作！！");
		}

	}

	// 处理登录
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) {
		// 获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		log.info("用户输入："+uname + ":" + pwd);
		
		// 处理请求信息
		// --获取service层对象
		UserService us = new UserServiceImpl();
		// --校验
		User u = us.checkUserLoginService(uname, pwd);

		log.info("查询到的结果为："+u);
		// 响应请求结果
		// --直接响应
		// --请求转发
		// --重定向

	}

}
