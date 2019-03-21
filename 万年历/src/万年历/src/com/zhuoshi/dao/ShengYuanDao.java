package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.ShengYuanBean;
import com.zhuoshi.tool.DBsource;

public class ShengYuanDao {

	//删除多条数据
	public int delectallShengYuans(List<ShengYuanBean> shengyuans) {
		PreparedStatement p = null;
		int n = 0;
		Connection conn = DBsource.getConn();
		try {
			for (ShengYuanBean bean : shengyuans) {
				String sql = "delete from shengyuandi where id=?";
				p = conn.prepareStatement(sql);
				p.setInt(1, bean.getId());
				p.executeUpdate();
			}			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			n = 1;
			e.printStackTrace();
		}finally{
		DBsource.closeAll(conn, p, null);
		}
		return n;

	}
	
	// 添加多条数据
	public int addShengYuans(List<ShengYuanBean> shengyuans) {
		PreparedStatement p = null;
		int n = 0;
		Connection conn = DBsource.getConn();
		try {
			// 开启事务
			conn.setAutoCommit(false);
			for (ShengYuanBean bean : shengyuans) {
				String sql = "insert into shengyuandi(sydcode,sydname) values(?,?)";
				p = conn.prepareStatement(sql);
				p.setString(1, bean.getSydcode());
				p.setString(2, bean.getSydname());
				p.executeUpdate();
			}
			//提交事务
			conn.commit();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			n = 1;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
		DBsource.closeAll(conn, p, null);
		}
		return n;

	}
	
	
	
	
	// 添加
	public int addShengYuan(ShengYuanBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "insert into shengyuandi(sydcode,sydname) values(?,?)";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getSydcode());
			p.setString(2, bean.getSydname());
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
	public int deleteShengYuan(int id) {
		Connection conn = DBsource.getConn();
		String sql = "delete from shengyuandi where id=?";
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

	// 修改
	public int updateShengYuan(ShengYuanBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "update shengyuandi set sydcode=?,sydname=? where id=?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getSydcode());
			p.setString(2, bean.getSydname());
			p.setInt(3, bean.getId());
			rows = p.executeUpdate();

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}

	// 通过主键查询单条数据
	public ShengYuanBean selectById(int id) {
		Connection conn = DBsource.getConn();
		String sql = "select * from shengyuandi where id=?";
		PreparedStatement p = null;
		ResultSet rs = null;
		ShengYuanBean bean = null;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			if (rs.next()) {
				bean = new ShengYuanBean();
				bean.setId(rs.getInt("id"));
				bean.setSydcode(rs.getString("sydcode"));
				bean.setSydname(rs.getString("sydname"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return bean;
	}

	// 查询全部
	public List<ShengYuanBean> selectAll() {
		Connection conn = DBsource.getConn();
		String sql = "select * from shengyuandi";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<ShengYuanBean> shengyuans = new ArrayList<ShengYuanBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				ShengYuanBean bean = new ShengYuanBean();
				bean.setId(rs.getInt("id"));
				bean.setSydcode(rs.getString("sydcode"));
				bean.setSydname(rs.getString("sydname"));
				shengyuans.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return shengyuans;
	}

	// 按条件查询全部
	public List<ShengYuanBean> selectAll(ShengYuanBean bean) {
		Connection conn = DBsource.getConn();

		String sql = "select * from shengyuandi where 1=1";
		// 拼装sql语句
		if (!bean.getSydcode().equals("")) {
			sql += " and sydcode like '%" + bean.getSydcode() + "%'";
		}
		if (!bean.getSydname().equals("")) {
			sql += " and sydname like '%" + bean.getSydname() + "%'";
		}
		PreparedStatement p = null;
		ResultSet rs = null;
		List<ShengYuanBean> shengyuans = new ArrayList<ShengYuanBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				ShengYuanBean shengYuanBean = new ShengYuanBean();
				shengYuanBean.setId(rs.getInt("id"));
				shengYuanBean.setSydcode(rs.getString("sydcode"));
				shengYuanBean.setSydname(rs.getString("sydname"));
				shengyuans.add(shengYuanBean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return shengyuans;
	}

	// 查询一共有多少条数据
	public int count() {
		Connection conn = DBsource.getConn();
		String sql = "select count(*) as geshu from shengyuandi";
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

	// 按照分页查询
	public List<ShengYuanBean> selectAll(int begin, int rowsByPage) {
		Connection conn = DBsource.getConn();
		String sql = "select * from shengyuandi limit ?,?";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<ShengYuanBean> shengyuans = new ArrayList<ShengYuanBean>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, begin);
			p.setInt(2, rowsByPage);
			rs = p.executeQuery();
			while (rs.next()) {
				ShengYuanBean bean = new ShengYuanBean();
				bean.setId(rs.getInt("id"));
				bean.setSydcode(rs.getString("sydcode"));
				bean.setSydname(rs.getString("sydname"));
				shengyuans.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return shengyuans;
	}

}
