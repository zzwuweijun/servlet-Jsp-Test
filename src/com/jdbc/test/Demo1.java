package com.jdbc.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Demo1 {
	private static String dbUrl = "jdbc:mysql://localhost:3306/my_ruankao";
	private static String dbUserName = "root";
	private static String dbpassword = "123456";
	private static String jdbcName = "com.mysql.jdbc.Driver";

	public static void mysql() {
		try {
			Class.forName(jdbcName);
			System.out.println("加载驱动成功!");

		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败!");
		}
		Connection con = null;
		try {
			// 获取数据库连接
			con = (Connection) DriverManager.getConnection(dbUrl, dbUserName, dbpassword);
			System.out.println("获取数据库连接成功");
			Statement s = (Statement) con.createStatement();
			System.out.println(".....");
			String str = "SELECT `name`,`password` FROM user";
			ResultSet r =  s.executeQuery(str);
			System.out.println();
			System.out.println("----");
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败");
		} finally {
			try {
				// 关闭连接
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		mysql();
	}
}
