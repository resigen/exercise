package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.RoleBean;
import com.zhuoshi.bean.UserBean;
import com.zhuoshi.tool.DBsource;

public class RoleDao {
	public List<RoleBean> selectAll() {
		Connection conn = DBsource.getConn();
		String sql = "select * from role";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<RoleBean> roles = new ArrayList<RoleBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				RoleBean bean = new RoleBean();
				bean.setId(rs.getInt("id"));
				bean.setRolename(rs.getString("rolename"));
				roles.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return roles;
	}
	//通过Id查找角色名称
	public String selectById(int id){
		Connection conn = DBsource.getConn();
		String sql = "select * from role where id=?";
		PreparedStatement p = null;
		ResultSet rs = null;
		String rolename = null;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1,id);
			rs = p.executeQuery();
			if (rs.next()) {
				rolename = rs.getString("rolename");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return rolename;
	}
	
	
	
	
	
	
	

}
