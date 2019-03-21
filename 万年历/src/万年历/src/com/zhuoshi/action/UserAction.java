package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.UserBean;
import com.zhuoshi.dao.UserDao;

public class UserAction {
	private UserDao userDao= new UserDao();
    public UserBean login(UserBean user){		
		return userDao.login(user);
	}
	public int updateUserDenglucishu(UserBean bean) {
		return userDao.updateUserDenglucishu(bean);
	}
	public int updateUserpassword(UserBean bean) {
		return userDao.updateUserpassword(bean);
	}
	public UserBean selectById(int id) {
		return userDao.selectById(id);
	}
	public int updateUserShenheCishu(UserBean bean) {
		return userDao.updateUserShenheCishu(bean);
	}

	public List<UserBean> selectshenhe(int shenhe) {
		return userDao.selectshenhe(shenhe);
	}
	public int updateUserShenheName(int id) {
		return userDao.updateUserShenheName(id);
	}
	public int updateUserShenheName2(int id) {
		return userDao.updateUserShenheName2(id);
	}
	public int updateallUserShenheName(List<BenkeShengyuanBean> ids) {
		return userDao.updateallUserShenheName(ids);
	}
	public int updateallUserShenheName2(List<BenkeShengyuanBean> ids) {
		return userDao.updateallUserShenheName2(ids);
	}
	public int count() {
		return userDao.count();
	}
	public List<UserBean> selectAll(int begin, int rowsByPage) {
		return userDao.selectAll(begin, rowsByPage);
	}
	public List<UserBean> selectAll() {
		return userDao.selectAll();
	}
	public int deleteuser(int id) {
		return userDao.deleteuser(id);
	}
	public int addUser(UserBean bean) {
		return userDao.addUser(bean);
	}
	public List<UserBean> selectAll(UserBean bean) {
		return userDao.selectAll(bean);
	}

}
