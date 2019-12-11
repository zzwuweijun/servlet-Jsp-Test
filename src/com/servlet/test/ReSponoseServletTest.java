package com.servlet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReSponoseServletTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("....");
		resp.getWriter().write("111");
		resp.setContentType("utf-8");
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		resp.addHeader("Content-Type", "text/html;charset=utf-8");
	}
}
