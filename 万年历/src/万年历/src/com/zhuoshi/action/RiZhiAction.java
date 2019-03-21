package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.RiZiBean;
import com.zhuoshi.dao.RiZiDao;

public class RiZhiAction {
	RiZiDao rAction= new RiZiDao();
	public int addrizhi() {
		return rAction.addrizhi();
	}
	public List<RiZiBean> selectAll() {
		return rAction.selectAll();
	}

}
