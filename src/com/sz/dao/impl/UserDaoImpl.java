package com.sz.dao.impl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sz.dao.UserDao;
import com.sz.pojo.User;

public class UserDaoImpl implements UserDao {
	// 根据用户名和密码查询用户信息
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		// 声明jdbc对象
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		java.sql.ResultSet rs = null;
		// 声明变量
		User u = null;

		try {
//			// 创建sql命令
			String sql = "select * from user where uname=? and pwd=?";
			rs = MySql.query(sql, uname, pwd);
			
			// 遍历结果
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		// 返回查询结果
		return u;
	}

}
