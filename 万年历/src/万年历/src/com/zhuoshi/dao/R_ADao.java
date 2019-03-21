package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.R_ABean;
import com.zhuoshi.bean.RoleBean;
import com.zhuoshi.tool.DBsource;
//根据角色ID,查找有哪些权限
public class R_ADao {
	public List<R_ABean> selectByRid(int rid) {
		Connection conn = DBsource.getConn();
		String sql = "select * from r_a where rid=?";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<R_ABean> ras = new ArrayList<R_ABean>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1,rid);
			rs = p.executeQuery();
			while (rs.next()) {
				R_ABean bean = new R_ABean();
				bean.setId(rs.getInt("id"));
				bean.setRid(rs.getInt("rid"));
				bean.setAid(rs.getInt("aid"));
				ras.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return ras;
	}
}
