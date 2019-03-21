package com.zhuoshi.tool;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBsource {
	/**
	 * ����������ݿ�Ķ���
	 * 
	 * @return ���Ӷ���
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			Properties ps = new Properties();
			ps.load(new FileInputStream("db.properties"));
			String driver = ps.getProperty("driver");
			String url = ps.getProperty("url");
			String username = ps.getProperty("username");
			String password = ps.getProperty("password");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeAll(Connection conn, PreparedStatement stmt,
			ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
