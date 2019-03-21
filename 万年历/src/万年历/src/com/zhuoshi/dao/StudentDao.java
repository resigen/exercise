package com.zhuoshi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.AuthorityBean;
import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.tool.DBsource;

public class StudentDao {
	
	
	// 添加多条数据
	public int addStudents(List<StudentBean> students) {
		PreparedStatement p = null;
		int n = 0;
		Connection conn = DBsource.getConn();
		try {
			// 开启事务
			conn.setAutoCommit(false);
			for (StudentBean bean : students) {
				String sql = "insert into student(name,sex,age,address) values(?,?,?,?)";
				p = conn.prepareStatement(sql);
				p.setString(1, bean.getName());
				p.setString(2, bean.getSex());
				p.setInt(3, bean.getAge());
				p.setString(4, bean.getAddress());
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
	public int addStudent(StudentBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "insert into student(name,sex,age,address) values(?,?,?,?)";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getName());
			p.setString(2, bean.getSex());
			p.setInt(3, bean.getAge());
			p.setString(4, bean.getAddress());
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
	public int deleteStudent(int id) {
		Connection conn = DBsource.getConn();
		String sql = "delete from student where id=?";
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
	public int updateStudent(StudentBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "update student set name=?,sex=?,age=?,address=? where id=?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getName());
			p.setString(2, bean.getSex());
			p.setInt(3, bean.getAge());
			p.setString(4, bean.getAddress());
			p.setInt(5, bean.getId());
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
	public StudentBean selectById(int id) {
		Connection conn = DBsource.getConn();
		String sql = "select * from student where id=?";
		PreparedStatement p = null;
		ResultSet rs = null;
		StudentBean bean = null;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			if (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setAge(rs.getInt("age"));
				bean.setAddress(rs.getString("address"));
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
	public List<StudentBean> selectAll() {
		Connection conn = DBsource.getConn();
		String sql = "select * from student";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<StudentBean> students = new ArrayList<StudentBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setAge(rs.getInt("age"));
				bean.setAddress(rs.getString("address"));
				students.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return students;
	}

	// 按条件查询全部
	public List<StudentBean> selectAll(StudentBean studentBean) {
		Connection conn = DBsource.getConn();

		String sql = "select * from student where 1=1";
		// 拼装sql语句
		if (!studentBean.getName().equals("")) {
			sql += " and name like '%" + studentBean.getName() + "%'";
		}
		if (!studentBean.getAddress().equals("")) {
			sql += " and address like '%" + studentBean.getAddress() + "%'";
		}
		PreparedStatement p = null;
		ResultSet rs = null;
		List<StudentBean> students = new ArrayList<StudentBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setAge(rs.getInt("age"));
				bean.setAddress(rs.getString("address"));
				students.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return students;
	}

	// 查询一共有多少条数据
	public int count() {
		Connection conn = DBsource.getConn();
		String sql = "select count(*) as geshu from student";
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
	//按照分页查询
	public List<StudentBean> selectAll(int begin,int rowsByPage) {
		Connection conn = DBsource.getConn();
		String sql = "select * from student limit ?,?";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<StudentBean> students = new ArrayList<StudentBean>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1,begin);
			p.setInt(2,rowsByPage);
			rs = p.executeQuery();
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setAge(rs.getInt("age"));
				bean.setAddress(rs.getString("address"));
				students.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return students;
	}

}
