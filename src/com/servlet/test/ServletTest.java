package com.servlet.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class ServletTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setCharacterEncoding("utf-8"); 
		resp.setContentType("text/html;charset=utf-8"); 
		
		resp.getWriter().write("我是service方法");
		System.out.println("我是service方法");
 
		System.out.println(req.getMethod() + "方法");
//		super.service(req, resp);  
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.getWriter().write("我是doGet方法");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("我是doGet方法");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.getWriter().write("我是doPost方法");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		获取全局的共享数据
		System.out.println("我是doPost方法");
		ServletContext s = this.getServletContext();
		s.getInitParameter("name");

	}
	
}

