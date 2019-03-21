package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.AuthorityBean;
import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.bean.YuanXiBean;
import com.zhuoshi.tool.DBsource;

public class YuanXiDao {
	public List<YuanXiBean> selectzyxy(){
		Connection conn = DBsource.getConn();
		String sql = "select p.id,c.collegename,p.professorname from college c,professor p"
				+ " where p.collegeid=c.id ";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<YuanXiBean> yuanxis = new ArrayList<YuanXiBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				YuanXiBean bean =new YuanXiBean();
				bean.setPid(rs.getInt("p.id"));
				bean.setCollegename(rs.getString("c.collegename"));
				bean.setProfessorname(rs.getString("p.professorname"));
				yuanxis.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return yuanxis;
	}
	
	public int count() {
		Connection conn = DBsource.getConn();
		String sql = "SELECT count(*)  as geshu from professor";
		PreparedStatement p = null;
		ResultSet rs = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			if (rs.next()) {
				
				rows = rs.getInt("geshu");			
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return rows;
	}
	
	public List<YuanXiBean> selectAll(int begin,int rowsByPage) {
		Connection conn = DBsource.getConn();
		String sql = "select p.id,c.collegename,p.professorname from college c,professor p"
				+ " where p.collegeid=c.id limit ?,?";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<YuanXiBean> yuanXis = new ArrayList<YuanXiBean>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1,begin);
			p.setInt(2,rowsByPage);
			rs = p.executeQuery();
			while (rs.next()) {
				YuanXiBean bean =new YuanXiBean();
				bean.setPid(rs.getInt("p.id"));
				bean.setCollegename(rs.getString("c.collegename"));
				bean.setProfessorname(rs.getString("p.professorname"));
				yuanXis.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return yuanXis;
	}
	
	public List<YuanXiBean> selectAll(YuanXiBean bean) {
		Connection conn = DBsource.getConn();

		String sql = "select p.id,c.collegename,p.professorname from college c,professor p"
				+ " where p.collegeid=c.id";
		// 拼装sql语句
		if (!bean.getCollegename().equals("")) {
			sql += " and c.collegename like '%" + bean.getCollegename() + "%'";
		}
		if (!bean.getProfessorname().equals("")) {
			sql += " and p.professorname like '%" + bean.getProfessorname() + "%'";
		}
		PreparedStatement p = null;
		ResultSet rs = null;
		List<YuanXiBean> yuanxis = new ArrayList<YuanXiBean>();
		try {
			p = conn.prepareStatement(sql);
			System.out.println(p.toString());
			rs = p.executeQuery();
			while (rs.next()) {
				YuanXiBean b =new YuanXiBean();
				b.setPid(rs.getInt("id"));
				b.setCollegename(rs.getString("collegename"));
				b.setProfessorname(rs.getString("professorname"));
				yuanxis.add(b);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return yuanxis;
	}
	
	public int deleteyuanxi(int id) {
		Connection conn = DBsource.getConn();
		String sql = "delete from professor where id=?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			rows = p.executeUpdate();

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}

}
