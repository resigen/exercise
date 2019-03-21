package com.zhuoshi.dao;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.tool.DBsource;

public class BenkeShengyuanDao {
	public int delectallBenkesys(List<BenkeShengyuanBean> benkesys) {
		PreparedStatement p = null;
		int n = 0;
		Connection conn = DBsource.getConn();
		try {
			for (BenkeShengyuanBean bean : benkesys) {
				String sql = "delete from benkesy where id=?";
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

	// 添加多条数据
	public int addAllBenkesys(List<BenkeShengyuanBean> benkesys) {
		PreparedStatement p = null;
		int n = 0;
		Connection conn = DBsource.getConn();
		try {
			// 开启事务
			conn.setAutoCommit(false);
			for (BenkeShengyuanBean bean : benkesys) {
				String sql = "insert into benkesy (kaoshenghao, name, sex, xuehao, minzu, zhengzhimianmiao, "
						+ "xueli, zhuanye, peiyang, shengyuandi, chusheng, shenfenzheng, ruxue, xuezhi, dingxiang, "
						+ "yuyan, xuejibiandong, biye, lianxidianhua, email, huko, waiyudengji, chengfa, xueyuan, "
						+ "nianji, beizhu, denglucishu) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				p = conn.prepareStatement(sql);
				p.setString(1, bean.getKaoshenghao());
				p.setString(2, bean.getName());
				p.setString(3, bean.getSex());
				p.setString(4, bean.getXuehao());
				p.setString(5, bean.getMinzu());
				p.setString(6, bean.getZhengzhimianmiao());
				p.setString(7, bean.getXueli());
				p.setString(8, bean.getZhuanye());
				p.setString(9, bean.getPeiyang());
				p.setString(10, bean.getShengyuandi());
				p.setString(11, bean.getChusheng());
				p.setString(12, bean.getShenfenzheng());
				p.setString(13, bean.getRuxue());
				p.setString(14, bean.getXuezhi());
				p.setString(15, bean.getDingxiang());
				p.setString(16, bean.getYuyan());
				p.setString(17, bean.getXuejibiandong());
				p.setString(18, bean.getBiye());
				p.setString(19, bean.getLianxidianhua());
				p.setString(20, bean.getEmail());
				p.setString(21, bean.getHuko());
				p.setString(22, bean.getWaiyudengji());
				p.setString(23, bean.getChengfa());
				p.setString(24, bean.getXueyuan());
				p.setString(25, bean.getNianji());
				p.setString(26, null);
				p.setString(27, "0");
				p.executeUpdate();
			}
			// 提交事务
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
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return n;

	}

	// 添加
	public int addBenkesy(BenkeShengyuanBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "insert into benkesy (kaoshenghao, name, sex, xuehao, minzu, zhengzhimianmiao, "
				+ "xueli, zhuanye, peiyang, shengyuandi, chusheng, shenfenzheng, ruxue, xuezhi, dingxiang, "
				+ "yuyan, xuejibiandong, biye, lianxidianhua, email, huko, waiyudengji, chengfa, xueyuan, "
				+ "nianji, beizhu, denglucishu) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getKaoshenghao());
			p.setString(2, bean.getName());
			p.setString(3, bean.getSex());
			p.setString(4, bean.getXuehao());
			p.setString(5, bean.getMinzu());
			p.setString(6, bean.getZhengzhimianmiao());
			p.setString(7, bean.getXueli());
			p.setString(8, bean.getZhuanye());
			p.setString(9, bean.getPeiyang());
			p.setString(10, bean.getShengyuandi());
			p.setString(11, bean.getChusheng());
			p.setString(12, bean.getShenfenzheng());
			p.setString(13, bean.getRuxue());
			p.setString(14, bean.getXuezhi());
			p.setString(15, bean.getDingxiang());
			p.setString(16, bean.getYuyan());
			p.setString(17, bean.getXuejibiandong());
			p.setString(18, bean.getBiye());
			p.setString(19, bean.getLianxidianhua());
			p.setString(20, bean.getEmail());
			p.setString(21, bean.getHuko());
			p.setString(22, bean.getWaiyudengji());
			p.setString(23, bean.getChengfa());
			p.setString(24, bean.getXueyuan());
			p.setString(25, bean.getNianji());
			p.setString(26, null);
			p.setString(27, "0");
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
	public int deleteBenkesy(int id) {
		Connection conn = DBsource.getConn();
		String sql = "delete from benkesy where id=?";
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
	
	//修改
	public int updateBksy(BenkeShengyuanBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "update benkesy set kaoshenghao =?,name=?,sex =?,"
				+ " xuehao=?,minzu=?,zhengzhimianmiao=?,xueyuan=?," + "zhuanye=?,nianji=?,xueli=?,"
				+ " xuezhi=?,waiyudengji=?,"
				+ " lianxidianhua=?,"
				+ " shenfenzheng=?,chengfa=?" + " where id =?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getKaoshenghao());
			p.setString(2, bean.getName());
			p.setString(3, bean.getSex());
			p.setString(4, bean.getXuehao());
			p.setString(5, bean.getMinzu());
			p.setString(6, bean.getZhengzhimianmiao());
			p.setString(7, bean.getXueyuan());
			p.setString(8, bean.getZhuanye());
			p.setString(9, bean.getNianji());
			p.setString(10, bean.getXueli());
			p.setString(11, bean.getXuezhi());
			p.setString(12, bean.getWaiyudengji());
			p.setString(13, bean.getLianxidianhua());
			p.setString(14, bean.getShenfenzheng());
			p.setString(15, bean.getChengfa());
			p.setInt(16, bean.getId());
			rows = p.executeUpdate();

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, null);
		}
		return rows;
	}

	// 修改全部
	public int updateBenkesy(BenkeShengyuanBean bean) {
		Connection conn = DBsource.getConn();
		String sql = "update benkesy set kaoshenghao =?,name=?,sex =?,"
				+ "xuehao=?,minzu=?,zhengzhimianmiao=?,xueyuan=?," + "zhuanye=?,peiyang=?,nianji=?,xueli=?,"
				+ "dingxiang=?,xuezhi=?,yuyan=?,waiyudengji=?,xuejibiandong=?,"
				+ "huko=?,shengyuandi=?,lianxidianhua=?,email=?,chusheng=?,ruxue=?,"
				+ "biye=?,shenfenzheng=?,chengfa=?,denglucishu=?,beizhu=? " + "where id =?";
		PreparedStatement p = null;
		int rows = 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, bean.getKaoshenghao());
			p.setString(2, bean.getName());
			p.setString(3, bean.getSex());
			p.setString(4, bean.getXuehao());
			p.setString(5, bean.getMinzu());
			p.setString(6, bean.getZhengzhimianmiao());
			p.setString(7, bean.getXueyuan());
			p.setString(8, bean.getZhuanye());
			p.setString(9, bean.getPeiyang());
			p.setString(10, bean.getNianji());
			p.setString(11, bean.getXueli());
			p.setString(12, bean.getDingxiang());
			p.setString(13, bean.getXuezhi());
			p.setString(14, bean.getYuyan());
			p.setString(15, bean.getWaiyudengji());
			p.setString(16, bean.getXuejibiandong());
			p.setString(17, bean.getHuko());
			p.setString(18, bean.getShengyuandi());
			p.setString(19, bean.getLianxidianhua());
			p.setString(20, bean.getEmail());
			p.setString(21, bean.getChusheng());
			p.setString(22, bean.getRuxue());
			p.setString(23, bean.getBiye());
			p.setString(24, bean.getShenfenzheng());
			p.setString(25, bean.getChengfa());
			p.setString(26, bean.getDenglucishu());
			p.setString(27, bean.getBeizhu());
			p.setInt(28, bean.getId());
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
	public BenkeShengyuanBean selectById(int id) {
		Connection conn = DBsource.getConn();
		String sql = "select * from benkesy where id=?";
		PreparedStatement p = null;
		ResultSet rs = null;
		BenkeShengyuanBean bean = null;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			if (rs.next()) {
				bean = new BenkeShengyuanBean();
				bean.setId(rs.getInt("id"));
				bean.setKaoshenghao(rs.getString("kaoshenghao"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setXuehao(rs.getString("xuehao"));
				bean.setMinzu(rs.getString("minzu"));
				bean.setZhengzhimianmiao(rs.getString("zhengzhimianmiao"));
				bean.setXueli(rs.getString("xueli"));
				bean.setZhuanye(rs.getString("zhuanye"));
				bean.setPeiyang(rs.getString("peiyang"));
				bean.setShengyuandi(rs.getString("shengyuandi"));
				bean.setChusheng(rs.getString("chusheng"));
				bean.setShenfenzheng(rs.getString("shenfenzheng"));
				bean.setRuxue(rs.getString("ruxue"));
				bean.setXuezhi(rs.getString("xuezhi"));
				bean.setDingxiang(rs.getString("dingxiang"));
				bean.setYuyan(rs.getString("yuyan"));
				bean.setXuejibiandong(rs.getString("xuejibiandong"));
				bean.setBiye(rs.getString("biye"));
				bean.setLianxidianhua(rs.getString("lianxidianhua"));
				bean.setEmail(rs.getString("email"));
				bean.setHuko(rs.getString("huko"));
				bean.setWaiyudengji(rs.getString("waiyudengji"));
				bean.setChengfa(rs.getString("chengfa"));
				bean.setXueyuan(rs.getString("xueyuan"));
				bean.setNianji(rs.getString("nianji"));
				bean.setBeizhu(rs.getString("beizhu"));
				bean.setDenglucishu(rs.getString("denglucishu"));
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
	public List<BenkeShengyuanBean> selectAll() {
		Connection conn = DBsource.getConn();
		String sql = "select * from benkesy";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				BenkeShengyuanBean bean = new BenkeShengyuanBean();
				bean.setId(rs.getInt("id"));
				bean.setKaoshenghao(rs.getString("kaoshenghao"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setXuehao(rs.getString("xuehao"));
				bean.setMinzu(rs.getString("minzu"));
				bean.setZhengzhimianmiao(rs.getString("zhengzhimianmiao"));
				bean.setXueli(rs.getString("xueli"));
				bean.setZhuanye(rs.getString("zhuanye"));
				bean.setPeiyang(rs.getString("peiyang"));
				bean.setShengyuandi(rs.getString("shengyuandi"));
				bean.setChusheng(rs.getString("chusheng"));
				bean.setShenfenzheng(rs.getString("shenfenzheng"));
				bean.setRuxue(rs.getString("ruxue"));
				bean.setXuezhi(rs.getString("xuezhi"));
				bean.setDingxiang(rs.getString("dingxiang"));
				bean.setYuyan(rs.getString("yuyan"));
				bean.setXuejibiandong(rs.getString("xuejibiandong"));
				bean.setBiye(rs.getString("biye"));
				bean.setLianxidianhua(rs.getString("lianxidianhua"));
				bean.setEmail(rs.getString("email"));
				bean.setHuko(rs.getString("huko"));
				bean.setWaiyudengji(rs.getString("waiyudengji"));
				bean.setChengfa(rs.getString("chengfa"));
				bean.setXueyuan(rs.getString("xueyuan"));
				bean.setNianji(rs.getString("nianji"));
				bean.setBeizhu(rs.getString("beizhu"));
				bean.setDenglucishu(rs.getString("denglucishu"));
				benkesys.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benkesys;
	}

	// 按条件查询全部
	public List<BenkeShengyuanBean> selectAll(BenkeShengyuanBean bean) {
		Connection conn = DBsource.getConn();

		String sql = "select * from benkesy where 1=1 ";
		// 拼装sql语句
		if (bean.getXinxiname().equals("学号")) {
			if (!bean.getXinxi().equals("")) {
				sql += " and xuehao like '%" + bean.getXinxi() + "%'";
			}
		}
		if (bean.getXinxiname().equals("姓名") && !bean.getXinxi().equals("")) {
			sql += " and name like '%" + bean.getXinxi() + "%'";
		}
		if (bean.getXinxiname().equals("专业") && !bean.getXinxi().equals("")) {
			sql += " and zhuanye like '%" + bean.getXinxi() + "%'";
		}
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				BenkeShengyuanBean benkesybean = new BenkeShengyuanBean();
				benkesybean.setId(rs.getInt("id"));
				benkesybean.setKaoshenghao(rs.getString("kaoshenghao"));
				benkesybean.setName(rs.getString("name"));
				benkesybean.setSex(rs.getString("sex"));
				benkesybean.setXuehao(rs.getString("xuehao"));
				benkesybean.setMinzu(rs.getString("minzu"));
				benkesybean.setZhengzhimianmiao(rs.getString("zhengzhimianmiao"));
				benkesybean.setXueli(rs.getString("xueli"));
				benkesybean.setZhuanye(rs.getString("zhuanye"));
				benkesybean.setPeiyang(rs.getString("peiyang"));
				benkesybean.setShengyuandi(rs.getString("shengyuandi"));
				benkesybean.setChusheng(rs.getString("chusheng"));
				benkesybean.setShenfenzheng(rs.getString("shenfenzheng"));
				benkesybean.setRuxue(rs.getString("ruxue"));
				benkesybean.setXuezhi(rs.getString("xuezhi"));
				benkesybean.setDingxiang(rs.getString("dingxiang"));
				benkesybean.setYuyan(rs.getString("yuyan"));
				benkesybean.setXuejibiandong(rs.getString("xuejibiandong"));
				benkesybean.setBiye(rs.getString("biye"));
				benkesybean.setLianxidianhua(rs.getString("lianxidianhua"));
				benkesybean.setEmail(rs.getString("email"));
				benkesybean.setHuko(rs.getString("huko"));
				benkesybean.setWaiyudengji(rs.getString("waiyudengji"));
				benkesybean.setChengfa(rs.getString("chengfa"));
				benkesybean.setXueyuan(rs.getString("xueyuan"));
				benkesybean.setNianji(rs.getString("nianji"));
				benkesybean.setBeizhu(rs.getString("beizhu"));
				benkesybean.setDenglucishu(rs.getString("denglucishu"));
				benkesys.add(benkesybean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benkesys;
	}

	// 查询一共有多少条数据
	public int count() {
		Connection conn = DBsource.getConn();
		String sql = "select count(*) as geshu from benkesy";
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
	public List<BenkeShengyuanBean> selectAll(int begin, int rowsByPage) {
		Connection conn = DBsource.getConn();
		String sql = "select * from benkesy limit ?,?";
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenkeShengyuanBean> benyesys = new ArrayList<BenkeShengyuanBean>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, begin);
			p.setInt(2, rowsByPage);
			rs = p.executeQuery();
			while (rs.next()) {
				BenkeShengyuanBean bean = new BenkeShengyuanBean();
				bean.setId(rs.getInt("id"));
				bean.setKaoshenghao(rs.getString("kaoshenghao"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setXuehao(rs.getString("xuehao"));
				bean.setMinzu(rs.getString("minzu"));
				bean.setZhengzhimianmiao(rs.getString("zhengzhimianmiao"));
				bean.setXueli(rs.getString("xueli"));
				bean.setZhuanye(rs.getString("zhuanye"));
				bean.setPeiyang(rs.getString("peiyang"));
				bean.setShengyuandi(rs.getString("shengyuandi"));
				bean.setChusheng(rs.getString("chusheng"));
				bean.setShenfenzheng(rs.getString("shenfenzheng"));
				bean.setRuxue(rs.getString("ruxue"));
				bean.setXuezhi(rs.getString("xuezhi"));
				bean.setDingxiang(rs.getString("dingxiang"));
				bean.setYuyan(rs.getString("yuyan"));
				bean.setXuejibiandong(rs.getString("xuejibiandong"));
				bean.setBiye(rs.getString("biye"));
				bean.setLianxidianhua(rs.getString("lianxidianhua"));
				bean.setEmail(rs.getString("email"));
				bean.setHuko(rs.getString("huko"));
				bean.setWaiyudengji(rs.getString("waiyudengji"));
				bean.setChengfa(rs.getString("chengfa"));
				bean.setXueyuan(rs.getString("xueyuan"));
				bean.setNianji(rs.getString("nianji"));
				bean.setBeizhu(rs.getString("beizhu"));
				bean.setDenglucishu(rs.getString("denglucishu"));
				benyesys.add(bean);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benyesys;
	}
	// 通过ID查询全部
	public List<BenkeShengyuanBean> selectAllbyid(List<Integer> ids) {
		Connection conn = DBsource.getConn();
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
		try {
			for (Integer id : ids) {
			String sql = "select * from benkesy where id=?";
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();	
			if (rs.next()) {
				BenkeShengyuanBean bean = new BenkeShengyuanBean();
				bean.setId(rs.getInt("id"));
				bean.setKaoshenghao(rs.getString("kaoshenghao"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setXuehao(rs.getString("xuehao"));
				bean.setMinzu(rs.getString("minzu"));
				bean.setZhengzhimianmiao(rs.getString("zhengzhimianmiao"));
				bean.setXueli(rs.getString("xueli"));
				bean.setZhuanye(rs.getString("zhuanye"));
				bean.setPeiyang(rs.getString("peiyang"));
				bean.setShengyuandi(rs.getString("shengyuandi"));
				bean.setChusheng(rs.getString("chusheng"));
				bean.setShenfenzheng(rs.getString("shenfenzheng"));
				bean.setRuxue(rs.getString("ruxue"));
				bean.setXuezhi(rs.getString("xuezhi"));
				bean.setDingxiang(rs.getString("dingxiang"));
				bean.setYuyan(rs.getString("yuyan"));
				bean.setXuejibiandong(rs.getString("xuejibiandong"));
				bean.setBiye(rs.getString("biye"));
				bean.setLianxidianhua(rs.getString("lianxidianhua"));
				bean.setEmail(rs.getString("email"));
				bean.setHuko(rs.getString("huko"));
				bean.setWaiyudengji(rs.getString("waiyudengji"));
				bean.setChengfa(rs.getString("chengfa"));
				bean.setXueyuan(rs.getString("xueyuan"));
				bean.setNianji(rs.getString("nianji"));
				bean.setBeizhu(rs.getString("beizhu"));
				bean.setDenglucishu(rs.getString("denglucishu"));
					benkesys.add(bean);
			}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benkesys;
	}
	
	//统计专业
	public List<BenkeShengyuanBean> selectallzhuanye() {
		Connection conn = DBsource.getConn();
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
		try {			
			String sql = "select zhuanye from benkesy group by zhuanye";
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();	
			while(rs.next()) {
				BenkeShengyuanBean bean = new BenkeShengyuanBean();
				bean.setZhuanye(rs.getString("zhuanye"));
				benkesys.add(bean);
			
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benkesys;
	}
	//统计生源地
	public List<BenkeShengyuanBean> selectashengyuandi() {
		Connection conn = DBsource.getConn();
		PreparedStatement p = null;
		ResultSet rs = null;
		List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
		try {			
			String sql = "select left(shengyuandi,2)  from benkesy group by left(shengyuandi,2)";
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();	
			while(rs.next()) {
				BenkeShengyuanBean bean = new BenkeShengyuanBean();
				bean.setShengyuandi(rs.getString("left(shengyuandi,2)"));
				benkesys.add(bean);			
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return benkesys;
	}
	//统计各专业总人数
//	public List<BenkeShengyuanBean> selectzhuanyecount() {
//		Connection conn = DBsource.getConn();
//		PreparedStatement p = null;
//		ResultSet rs = null;
//		List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
//		try {			
//			String sql = "select zhuanye,count(zhuanye) from benkesy group by zhuanye";
//			p = conn.prepareStatement(sql);
//			rs = p.executeQuery();	
//			while(rs.next()) {
//				BenkeShengyuanBean bean = new BenkeShengyuanBean();
//				bean.setShengyuandi(rs.getString("zhuanye"));
//				bean.setCount(rs.getInt("count(zhuanye)"));
//				benkesys.add(bean);			
//			}
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} finally {
//			DBsource.closeAll(conn, p, rs);
//		}
//		return benkesys;
//	}
//	//统计各生源地总人数
//		public List<BenkeShengyuanBean> selectshengYDcount() {
//			Connection conn = DBsource.getConn();
//			PreparedStatement p = null;
//			ResultSet rs = null;
//			List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
//			try {			
//				String sql = "select left(shengyuandi,2),count(left(shengyuandi,2)) from benkesy group by left(shengyuandi,2)";
//				p = conn.prepareStatement(sql);
//				rs = p.executeQuery();	
//				while(rs.next()) {
//					BenkeShengyuanBean bean = new BenkeShengyuanBean();
//					bean.setShengyuandi(rs.getString("left(shengyuandi,2)"));
//					bean.setCount(rs.getInt("count(left(shengyuandi,2))"));
//					benkesys.add(bean);			
//				}
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			} finally {
//				DBsource.closeAll(conn, p, rs);
//			}
//			return benkesys;
//		}
		//统计各专业，各生源地的人数
//		public List<BenkeShengyuanBean> selectCount(List<BenkeShengyuanBean> zhuanYs) {
//			Connection conn = DBsource.getConn();
//			PreparedStatement p = null;
//			ResultSet rs = null;
//			List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
//			try {
//				for (BenkeShengyuanBean zhuanye : zhuanYs) {
//				String sql = "select left(shengyuandi,2),count(left(shengyuandi,2)) from benkesy "
//						+ "where zhuanye=? group by left(shengyuandi,2)";
//				p = conn.prepareStatement(sql);
//				p.setString(1,zhuanye.getZhuanye());
//				rs = p.executeQuery();	
//				if (rs.next()) {
//					BenkeShengyuanBean bean = new BenkeShengyuanBean();
//					bean.setShengyuandi(rs.getString("left(shengyuandi,2)"));
//					bean.setCount(rs.getInt("count(left(shengyuandi,2))"));
//				    benkesys.add(bean);
//				}
//				}
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			} finally {
//				DBsource.closeAll(conn, p, rs);
//			}
//		return benkesys;
//		}
	public int selectCount(String zhuanye,String diqu) {
		Connection conn = DBsource.getConn();
		String sql = "SELECT count(*) as count from benkesy "
				+ "WHERE zhuanye= ? and shengyuandi like '%"+diqu+"%'";
		PreparedStatement p = null;
		ResultSet rs = null;
		int n= 0;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1,zhuanye);
			rs = p.executeQuery();
			if (rs.next()) {
				n=rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBsource.closeAll(conn, p, rs);
		}
		return n;
	}

		
  
	
}
