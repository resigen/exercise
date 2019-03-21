package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.YuanXiBean;
import com.zhuoshi.dao.UserDao;
import com.zhuoshi.dao.YuanXiDao;

public class YuanXiAction {
	private YuanXiDao yxDao= new YuanXiDao();
	public List<YuanXiBean> selectzyxy(){
		return yxDao.selectzyxy();
	}
	public int count() {
		return yxDao.count();
	}
	public List<YuanXiBean> selectAll(int begin,int rowsByPage) {
		return yxDao.selectAll(begin, rowsByPage);
	}
	public List<YuanXiBean> selectAll(YuanXiBean bean) {
		return yxDao.selectAll(bean);
	}
	public int deleteyuanxi(int id) {
		return yxDao.deleteyuanxi(id);
	}

}
