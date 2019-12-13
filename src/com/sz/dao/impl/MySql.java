package com.sz.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySql {
	// 创建jdbc对象
	public static Connection con;
	public static Statement st;
	public static PreparedStatement ps;
	public static ResultSet rs;

	// 创建变量
	private static String sqlUrl;
	private static String sqlUser;
	private static String sqlPwd;

	public static void getPro() throws IOException {
		InputStream in = MySql.class.getResourceAsStream("/db.properties");
		Properties p = new Properties();
		p.load(in);
		sqlUrl = p.getProperty("sqlUrl");
		sqlUser = p.getProperty("sqlUser");
		sqlPwd = p.getProperty("sqlPwd");
	}
	

	// private static final String sqlUrl =
	// "jdbc:mysql://localhost:3306/my_servletjsptest";
	// private static final String sqlUser = "root";
	// private static final String sqlPwd = "123456";

	// 返回Connection对象的实例
	public static Connection getCon() {
		if (con == null) {
			try {
				MySql.getPro();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				// 加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				// 连接shujuk
				try {
					con = DriverManager.getConnection(sqlUrl, sqlUser, sqlPwd);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void main(String[] args) {
		MySql.getCon();
		try {
			ps = con.prepareStatement("select * from user where pwd='123';");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getObject(1) + "----" + rs.getObject(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			MySql.close(con, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 创建sql命令
	// 执行sql命令
	// 遍历执行结果
	// 返回数据

	// 关闭连接
	public static void close(Connection con, Statement st, ResultSet rs) throws SQLException {
		rs.close();
		st.close();
		con.close();
	}

	public static void close(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
		rs.close();
		ps.close();
		con.close();
	}

	public static void close(Connection con, Statement st) throws SQLException {
		st.close();
		con.close();
	}

	public static void close(Connection con, PreparedStatement ps) throws SQLException {
		ps.close();
		con.close();
	}

	// ----
	public static void close(PreparedStatement ps) throws SQLException {
		ps.close();
		MySql.con.close();
	}

	public static void close(Statement st) throws SQLException {
		ps.close();
		MySql.con.close();
	}

	public static void close(PreparedStatement ps, ResultSet rs) throws SQLException {
		rs.close();
		ps.close();
		MySql.con.close();
	}

	public static void close(Statement st, ResultSet rs) throws SQLException {
		rs.close();
		ps.close();
		MySql.con.close();
	}
}
