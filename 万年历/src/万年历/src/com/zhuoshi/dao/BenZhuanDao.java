package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.tool.DBsource;

public class BenZhuanDao {
	
	//ɾ����������
	public int delectallBenzhuans(List<BenZhuanBean> benzhuans) {
		PreparedStatement p = null;
		int n = 0;
		Connection conn = DBsource.getConn();
		try {
			for (BenZhuanBean bean : benzhuans) {
				String sql = "delete from benzhuanke where id=?";
				p = conn.prepareStatement(sql);
				p.setInt(1, bean.getId());
				p.executeUpdate();
			}			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			n = 1;
			e.printStackTrace();
		}finally{
		DBsource.closeAll(conn, p, null);
		}
		return n;

	}
	
	// ��Ӷ�������
	public int addBenzhuans(List<BenZhuanBean> benzhuans) {
		PreparedStatement p = null;
		int n = 0;
		Connection conn = DBsource.getConn();
		try {
			// ��������
			conn.setAutoCommit(false);
			for (BenZhuanBean bean : benzhuans) {
				String sql = "insert into benzhuanke(bzzycode,bzzyname) values(?,?)";
				p = conn.prepareStatement(sql);
				p.setString(1, bean.getBzzycode());
				p.setString(2, bean.getBzzyname());
				p.executeUpdate();
			}
			// �ύ����
			conn.commit();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
	
	
	
	
	// ���
	public int addBenzhuan(BenZhuanBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "insert into benzhuanke(bzzycode,bzzyname) values(?,?)";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getBzzycode());
			p.setString(2, bean.getBzzyname());
			rows = p.executeUpdate();

		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}

	// ɾ��
	public int deleteBenzhuan(int id) {
		Connection conn = DBsource.getConn();
		String sql = "delete from benzhuanke where id=?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			rows = p.executeUpdate();

		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}

	// �޸�
	public int updateBenzhuan(BenZhuanBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "update benzhuanke set bzzycode=?,bzzyname=? where id=?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getBzzycode());
			p.setString(2, bean.getBzzyname());
			p.setInt(3, bean.getId());
			rows = p.executeUpdate();

		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}

	// ͨ��������ѯ��������
	public BenZhuanBean selectById(int id) {
		Connection conn = DBsource.getConn();
		String sql = "select * from benzhuanke where id=?";
		PreparedStatement p = null;
		ResultSet rs = null;
		BenZhuanBean bean = null;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			if (rs.next()) {
				bean = new BenZhuanBean();
				bean.setId(rs.getInt("id"));
				bean.setBzzycode(rs.getString("bzzycode"));
				bean.setBzzyname(rs.getString("bzzyname"));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return bean;
	}

	// ��ѯȫ��
	public List<BenZhuanBean> selectAll() {
		Connection conn = DBsource.getConn();
		String sql = "select * from benzhuanke";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenZhuanBean> benzhuans = new ArrayList<BenZhuanBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				BenZhuanBean bean = new BenZhuanBean();
				bean.setId(rs.getInt("id"));
				bean.setBzzycode(rs.getString("bzzycode"));
				bean.setBzzyname(rs.getString("bzzyname"));
				benzhuans.add(bean);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benzhuans;
	}

	// ��������ѯȫ��
	public List<BenZhuanBean> selectAll(BenZhuanBean bean) {
		Connection conn = DBsource.getConn();

		String sql = "select * from benzhuanke where 1=1";
		// ƴװsql���
		if (!bean.getBzzycode().equals("")) {
			sql += " and bzzycode like '%" + bean.getBzzycode() + "%'";
		}
		if (!bean.getBzzyname().equals("")) {
			sql += " and bzzyname like '%" + bean.getBzzyname() + "%'";
		}
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenZhuanBean> benzhuans = new ArrayList<BenZhuanBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				BenZhuanBean benzhuanbean = new BenZhuanBean();
				benzhuanbean.setId(rs.getInt("id"));
				benzhuanbean.setBzzycode(rs.getString("bzzycode"));
				benzhuanbean.setBzzyname(rs.getString("bzzyname"));
				benzhuans.add(benzhuanbean);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benzhuans;
	}

	// ��ѯһ���ж���������
	public int count() {
		Connection conn = DBsource.getConn();
		String sql = "select count(*) as geshu from benzhuanke";
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return rows;
	}

	// ���շ�ҳ��ѯ
	public List<BenZhuanBean> selectAll(int begin, int rowsByPage) {
		Connection conn = DBsource.getConn();
		String sql = "select * from benzhuanke limit ?,?";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenZhuanBean> benzhuankes = new ArrayList<BenZhuanBean>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, begin);
			p.setInt(2, rowsByPage);
			rs = p.executeQuery();
			while (rs.next()) {
				BenZhuanBean bean = new BenZhuanBean();
				bean.setId(rs.getInt("id"));
				bean.setBzzycode(rs.getString("bzzycode"));
				bean.setBzzyname(rs.getString("bzzyname"));
				benzhuankes.add(bean);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benzhuankes;
	}


}
