package com.sz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sz.pojo.User;
import com.sz.service.UserService;
import com.sz.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	Logger log = Logger.getLogger(UserService.class);

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

		}else if (oper.equals("out")) {
			// 调用退出处理方法
			userOut(req, resp);
		} else {
			System.out.println("错误。。。！");
		}

	}

	private void userOut(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs = req.getSession();
		hs.invalidate();
		try {
			resp.sendRedirect(req.getContextPath()+"/main/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// 处理登录
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) {
		// 获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		log.debug(uname + ":" + pwd);
		// 处理请求信息
		// --获取service层对象
		UserService us = new UserServiceImpl();
		// --校验
		User u = us.checkUserLoginService(uname, pwd);
		log.debug(u);
		// --登录成功后将登录数据保存到session对象中
		if(u != null) {
			HttpSession hs = req.getSession();
			hs.setAttribute("user", u);
		}
		// 响应请求结果
		// --直接响应
		// --请求转发
		// --重定向
		String path = req.getContextPath();
		log.debug("path---" + path);
		try {
			resp.sendRedirect(path + "/main/index2.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
