package com.servlet.test;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServletTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 获取请求头数据
		System.out.println("......");
		System.out.println(req.getMethod());
		System.out.println(req.getRequestURL());
		System.out.println(req.getRequestURI());
		System.out.println(req.getScheme());
		System.out.println(req.getServerName());
		System.out.println(req.getServerPort());
//		 获取请求数据
		System.out.println(".......");
		System.out.println(req.getHeader("User-Agent"));
		System.out.println(req.getHeaderNames());
		Enumeration<String> en = req.getHeaderNames();
		while (en.hasMoreElements()) {
//			System.out.println(en.nextElement());
			String name = en.nextElement();
			String value = req.getHeader(name);
			System.out.println(name + ":" + value);
		}
//		  获取用户数据
		System.out.println(".......");
		System.out.println(req.getParameter("uname"));
		System.out.println(req.getParameter("pwd"));
		Map<String, String[]> m = req.getParameterMap();
		System.out.println(m);
		System.out.println(req.getParameterNames());
		System.out.println(req.getParameterValues("uname"));
	}
}
