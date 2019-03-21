package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.ShengYuanBean;
import com.zhuoshi.dao.ShengYuanDao;

public class ShengYuanAction {
	private ShengYuanDao shengyuanDao = new ShengYuanDao();

	public int addBenzhuan(ShengYuanBean bean) {
		return shengyuanDao.addShengYuan(bean);
	}

	public int deleteBenzhuan(int id) {
		return shengyuanDao.deleteShengYuan(id);
	}

	public int updateBenzhuan(ShengYuanBean bean) {
		return shengyuanDao.updateShengYuan(bean);
	}

	public ShengYuanBean selectById(int id) {
		return shengyuanDao.selectById(id);
	}

	public List<ShengYuanBean> selectAll(ShengYuanBean shengyuanBean, int begin, int rowsByPage) {
		List<ShengYuanBean> shengyuans = null;
		if (shengyuanBean == null && begin == 0 && rowsByPage == 0) {
			shengyuans = shengyuanDao.selectAll();
		}
		if (shengyuanBean != null && begin == 0 && rowsByPage == 0) {
			shengyuans = shengyuanDao.selectAll(shengyuanBean);
		}
		if (shengyuanBean == null && rowsByPage != 0) {
			shengyuans = shengyuanDao.selectAll(begin, rowsByPage);
		}

		return shengyuans;
	}

	public int count() {
		return shengyuanDao.count();
	}

	public int addBenzhuans(List<ShengYuanBean> shengyuans) {
		return shengyuanDao.addShengYuans(shengyuans);
	}

	public int delectallBenzhuans(List<ShengYuanBean> shengyuans) {
		return shengyuanDao.delectallShengYuans(shengyuans);
	}

}
