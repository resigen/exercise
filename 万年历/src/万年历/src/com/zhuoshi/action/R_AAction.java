package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.R_ABean;
import com.zhuoshi.bean.RoleBean;
import com.zhuoshi.dao.R_ADao;

public class R_AAction {
	private R_ADao dao = new R_ADao();

	public List<R_ABean> selectByRid(int rid) {
		return dao.selectByRid(rid);	
	}

}
