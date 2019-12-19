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
	public static Connection con = null;
	public static Statement st = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	// 创建变量
	private static String sqlUrl = null;
	private static String sqlUser = null;
	private static String sqlPwd = null;

	/**
	 * 获取属性文件 db.properties 的数据库信息
	 * 
	 * @throws IOException
	 */
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
	/**
	 * 获取连接数据库的连接类
	 * 
	 * @return Connection类型
	 */
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
			ps = con.prepareStatement("select * from user");
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

	/**
	 * 查询数据库信息并返回结果集
	 * 
	 * 实例："select * from user where uname=?"
	 * 
	 * @param sql       查询语句，为prepareStatement类型
	 * @param parameter 参数，为空或任意多个
	 * @return 返回Resultset类型的结果集
	 */
	public static ResultSet query(String sql, Object... parameter) {
		MySql.getCon();
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			if (parameter.length != 0) {
				for (int i = 0; i < parameter.length; i++) {
					ps.setObject(i + 1, parameter[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 更新或添加数据
	 * 
	 * 实例：1."UPDATE user SET age=18 where uname='李wu'"
	 * 
	 * 2."INSERT INTO user(uname, pwd) value(?, ?)", "李四", "123"
	 * 
	 * @param sql     查询语句，为prepareStatement类型
	 * @param objects parameter 参数，为空或任意多个
	 * @return 返回int类型的结果,表示成功或失败
	 */
	public static int update(String sql, Object... parameter) {
		MySql.getCon();
		int rs = 0;
		try {
			ps = con.prepareStatement(sql);
			if (parameter.length != 0) {
				for (int i = 0; i < parameter.length; i++) {
					ps.setObject(i + 1, parameter[i]);
				}
			}
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 关闭连接，//关闭连接,要确认不再使用jdbc后再close，要不然下次使用使会报错，说jdbc为空指针。
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
	
	public static void close( ResultSet rs) throws SQLException {
		rs.close();
		ps.close();
		MySql.con.close();
	}
}
