package com.sz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class test2 {
//	@Test
	public void test() {
		System.out.println("lllll");
	}
	
//	@Test
	public void t()  {
		ResultSet rs = null;
		rs = MySql.query("select * from user");
		try {
			while (rs.next()) {
				System.out.println(rs.getObject(1) + "----**--" + rs.getObject(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
//		int ii = MySql.update("INSERT INTO user(uname, pwd) value(?, ?)", "李四", "123");
//		int ii = MySql.update("INSERT INTO user(uname, pwd) value('李wu', '123')");
//		int ii = MySql.update("UPDATE user SET pwd=111 where uname='李wu'");
		int ii = MySql.update("UPDATE user SET age=18 where uname='李wu'");
		System.out.println(ii);
	}
}
