package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.bean.UserBean;
import com.zhuoshi.tool.DBsource;

public class UserDao {
	public UserBean login(UserBean user){
		UserBean bean = null;
		Connection conn = DBsource.getConn();
		String sql = "select * from user "
		        +"where username =? and password = ?";
		PreparedStatement p = null;
		ResultSet rs = null;
		int num = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1,user.getUsername());
			p.setString(2,user.getPassword());
			rs = p.executeQuery();
			if (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setDenglucishu(rs.getInt("denglucishu"));
				bean.setRid(rs.getInt("rid"));
				bean.setStuid(rs.getInt("stuid"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return bean;
		
	}
   //修改审核次数
	public int updateUserShenheCishu(UserBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "update user set shenhe=? where id=?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, bean.getShenhe());
			p.setInt(2, bean.getId());
			rows = p.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}
	public int updateUserDenglucishu(UserBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "update user set denglucishu=? where id=?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, bean.getDenglucishu());
			p.setInt(2, bean.getId());
			rows = p.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}
	//修改登录密码
		public int updateUserpassword(UserBean bean) {
			Connection conn = DBsource.getConn();
			String sql = "update user set password=? where id=?";
			PreparedStatement p = null;
			int rows = 0;
			try {
				p = conn.prepareStatement(sql);
				p.setString(1, bean.getNewpassword());
				p.setInt(2, bean.getId());
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
		public UserBean selectById(int id) {
			Connection conn = DBsource.getConn();
			String sql = "select * from user where id=?";
			PreparedStatement p = null;
			ResultSet rs = null;
			UserBean bean = null;
			try {
				p = conn.prepareStatement(sql);
				p.setInt(1, id);
				rs = p.executeQuery();
				if (rs.next()) {
					bean = new UserBean();
					bean.setUsername(rs.getString("username"));
					bean.setPassword(rs.getString("password"));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				DBsource.closeAll(conn, p, rs);
			}
			return bean;
		}
		// 查询审核数
		public List<UserBean> selectshenhe(int shenhe) {
			Connection conn = DBsource.getConn();
			List<UserBean> users=new ArrayList<UserBean>();
			String sql = "select * from user where shenhe=?";
			PreparedStatement p = null;
			ResultSet rs = null;
			UserBean bean = null;
			try {
				p = conn.prepareStatement(sql);
				p.setInt(1,shenhe);
				rs = p.executeQuery();
				while(rs.next()) {					
					bean = new UserBean();					
					bean.setStuid(rs.getInt("stuid"));
					users.add(bean);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				DBsource.closeAll(conn, p, rs);
			}
		return users;
		}
		
		//修改审核(导员)
		public int updateUserShenheName(int id) {
			Connection conn = DBsource.getConn();
			String sql = "update user set shenhe=2 where stuid=?";
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
			//修改审核(就业指导中心)
			public int updateUserShenheName2(int id) {
				Connection conn = DBsource.getConn();
				String sql = "update user set shenhe=3 where stuid=?";
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
			
			//批量修改审核(导员)
			public int updateallUserShenheName(List<BenkeShengyuanBean> ids) {
				PreparedStatement p = null;
				int n = 0;
				Connection conn = DBsource.getConn();
				try {
					for (BenkeShengyuanBean bean : ids) {
						String sql = "update user set shenhe=2 where stuid=?";
						p = conn.prepareStatement(sql);
						p.setInt(1, bean.getId());
						p.executeUpdate();
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					n = 1;
					e.printStackTrace();
				} finally {
					DBsource.closeAll(conn, p, null);
				}
				return n;
			}
			//批量修改审核(就业指导中心)
			public int updateallUserShenheName2(List<BenkeShengyuanBean> ids) {
				PreparedStatement p = null;
				int n = 0;
				Connection conn = DBsource.getConn();
				try {
					for (BenkeShengyuanBean bean : ids) {
						String sql = "update user set shenhe=3 where stuid=?";
						p = conn.prepareStatement(sql);
						p.setInt(1, bean.getId());
						p.executeUpdate();
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					n = 1;
					e.printStackTrace();
				} finally {
					DBsource.closeAll(conn, p, null);
				}
				return n;
			}
			
	public int count() {
				Connection conn = DBsource.getConn();
				String sql = "select count(*) as geshu from user";
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
	
	public List<UserBean> selectAll(int begin, int rowsByPage) {
		Connection conn = DBsource.getConn();
		String sql = "select * from user limit ?,?";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<UserBean> us = new ArrayList<UserBean>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, begin);
			p.setInt(2, rowsByPage);
			rs = p.executeQuery();
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				us.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return us;
	}
	
	public List<UserBean> selectAll() {
		Connection conn = DBsource.getConn();
		String sql = "select * from user";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<UserBean> users = new ArrayList<UserBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				users.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return users;
	}
	public int deleteuser(int id) {
		Connection conn = DBsource.getConn();
		String sql = "delete from user where id=?";
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
	
	public int addUser(UserBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "insert into user(username,password,rid) values(?,?,?)";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getUsername());
			p.setString(2, bean.getPassword());
			if(bean.getJuese().equals("学生")){
			   p.setInt(3, 1);
			}
			if(bean.getJuese().equals("辅导员")){
			   p.setInt(3, 2);
			}
			if(bean.getJuese().equals("就业指导中心")){
			   p.setInt(3, 3);
			}
			if(bean.getJuese().equals("管理员")){
			   p.setInt(3, 4);
			}   
			rows = p.executeUpdate();

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}
	
	public List<UserBean> selectAll(UserBean bean) {
		Connection conn = DBsource.getConn();

		String sql = "select * from user where 1=1";
		// 拼装sql语句
		if (!bean.getUsername().equals("")) {
			sql += " and username like '%" + bean.getUsername()+ "%'";
		}
		PreparedStatement p = null;
		ResultSet rs = null;
		List<UserBean> users = new ArrayList<UserBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return users;
	}

}
