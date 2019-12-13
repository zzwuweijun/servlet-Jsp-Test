package com.sz.dao.impl;

import java.awt.font.NumericShaper.Range;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;

public class test {
	public static PreparedStatement ps;
	static ResultSet rs;
	static Connection con;
	static org.apache.log4j.Logger log =org.apache.log4j.Logger.getLogger(test.class);  

	public static void main(String[] args) {
//		con = MySql.getCon();
//		try {
//			ps = con.prepareStatement("select * from user");
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				log.info("info信息");
//				System.out.println(rs.getObject(1) + "----" + rs.getObject(2));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			MySql.close(con, ps, rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		int a = 10;
		int b = 0;
		while (b < a) {
			log.info("信息。。。。。");
			b ++;
		}
	}

}
