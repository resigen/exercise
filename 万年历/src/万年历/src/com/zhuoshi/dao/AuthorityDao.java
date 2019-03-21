package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.AuthorityBean;
import com.zhuoshi.tool.DBsource;
//ͨ��pid����Ȩ������    �����Ƕ��������ֵ��List
public class AuthorityDao {
	public List<AuthorityBean> selectByPid(int pid){
		Connection conn = DBsource.getConn();
		String sql = "select * from authority where pid=?";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<AuthorityBean> authortitys = new ArrayList<AuthorityBean>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1,pid);
			rs = p.executeQuery();
			while (rs.next()) {
				AuthorityBean bean =new AuthorityBean();
				bean.setId(rs.getInt("id"));
				bean.setAname(rs.getString("aname"));
				bean.setUrl(rs.getString("url"));
				bean.setPid(rs.getInt("pid"));
				authortitys.add(bean);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return authortitys;
	}
	//ͨ��Ȩ�����ƣ�����url
	public String selectByAname(String aname){
		Connection conn = DBsource.getConn();
		String sql = "select * from authority where aname=?";
		PreparedStatement p = null;
		ResultSet rs = null;
        String url ="";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1,aname);
			rs = p.executeQuery();
			if(rs.next()) {
				url =rs.getString("url");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return url;
	}

}
