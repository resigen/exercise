package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.RiZiBean;
import com.zhuoshi.tool.DBsource;
import com.zhuoshi.view.Test;

public class RiZiDao {
	
	public int addrizhi() {
		Connection conn = DBsource.getConn();
		String sql = "insert into rizhi(username,cometime,awaytime) values(?,?,?)";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, Test.Rb1.getUsername());
			p.setString(2, Test.Rb1.getCometime());
			p.setString(3, Test.Rb2.getAwaytime());
			rows = p.executeUpdate();

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}
	//查询
	public List<RiZiBean> selectAll() {
		Connection conn = DBsource.getConn();
		String sql = "select * from rizhi";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<RiZiBean> rizhis = new ArrayList<RiZiBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				RiZiBean bean = new RiZiBean();
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setCometime(rs.getString("cometime"));
				bean.setAwaytime(rs.getString("awaytime"));
				rizhis.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return rizhis;
	}

}
