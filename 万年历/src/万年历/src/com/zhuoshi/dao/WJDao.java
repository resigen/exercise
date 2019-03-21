package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.ShengYuanBean;
import com.zhuoshi.bean.WJBean;
import com.zhuoshi.tool.DBsource;

public class WJDao {
	//查询全部
	public List<WJBean> selectAll() {
		Connection conn = DBsource.getConn();
		String sql = "select * from wenjuan";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<WJBean> wenjuans = new ArrayList<WJBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				WJBean bean = new WJBean();
				bean.setId(rs.getInt("id"));
				bean.setWenti(rs.getString("wenti"));
				bean.setDaan1(rs.getString("daan1"));
				bean.setDaan2(rs.getString("daan2"));
				bean.setDaan3(rs.getString("daan3"));
				bean.setFabu(rs.getString("fabu"));
				wenjuans.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return wenjuans;
	}
	
	// 通过主键查询单条数据
		public WJBean selectById(int id) {
			Connection conn = DBsource.getConn();
			String sql = "select * from wenjuan where id=?";
			PreparedStatement p = null;
			ResultSet rs = null;
			WJBean wenj=null;
			try {
				p = conn.prepareStatement(sql);
				p.setInt(1, id);
				rs = p.executeQuery();
				if (rs.next()) {
					wenj = new WJBean();
					wenj.setId(rs.getInt("id"));
					wenj.setWenti(rs.getString("wenti"));
					wenj.setDaan1(rs.getString("daan1"));
					wenj.setDaan2(rs.getString("daan2"));
					wenj.setDaan3(rs.getString("daan3"));
					wenj.setFabu(rs.getString("fabu"));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				DBsource.closeAll(conn, p, rs);
			}
			return wenj;
		}
		
		// 修改
		public int updatefabu(int id) {
			Connection conn = DBsource.getConn();
			String sql = "update wenjuan set fabu='已发布'   where id=?";
			PreparedStatement p = null;
			int rows = 0;
			try {
				p = conn.prepareStatement(sql);
				p.setInt(1,id);
				rows = p.executeUpdate();

			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				DBsource.closeAll(conn, p, null);
			}
			return rows;
		}
		// 删除
		public int deletewenti(int id) {
			Connection conn = DBsource.getConn();
			String sql = "delete from wenjuan where id=?";
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
		// 添加
		public int addwenti(WJBean bean) {
			Connection conn = DBsource.getConn();
			String sql = "insert into wenjuan(wenti,daan1,daan2,daan3) values(?,?,?,?)";
			PreparedStatement p = null;
			int rows = 0;
			try {
				p = conn.prepareStatement(sql);
				p.setString(1, bean.getWenti());
				p.setString(2, bean.getDaan1());
				p.setString(3, bean.getDaan2());
				p.setString(4, bean.getDaan3());
				rows = p.executeUpdate();

			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				DBsource.closeAll(conn, p, null);
			}
			return rows;
		}
		// 按条件查询全部
		public List<WJBean> selectAllbyfabu() {
			Connection conn = DBsource.getConn();

			String sql = "select * from wenjuan where fabu='已发布' ";
			PreparedStatement p = null;
			ResultSet rs = null;
			List<WJBean> wentis = new ArrayList<WJBean>();
			try {
				p = conn.prepareStatement(sql);
				rs = p.executeQuery();
				while (rs.next()) {
					WJBean wentiBean = new WJBean();
					wentiBean.setId(rs.getInt("id"));
					wentiBean.setWenti(rs.getString("wenti"));
					wentiBean.setDaan1(rs.getString("daan1"));
					wentiBean.setDaan2(rs.getString("daan2"));
					wentiBean.setDaan3(rs.getString("daan3"));
					wentis.add(wentiBean);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				DBsource.closeAll(conn, p, rs);
			}
			return wentis;
		}

}
