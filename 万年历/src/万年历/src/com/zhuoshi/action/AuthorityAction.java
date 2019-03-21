package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.AuthorityBean;
import com.zhuoshi.bean.RoleBean;
import com.zhuoshi.dao.AuthorityDao;
import com.zhuoshi.dao.RoleDao;

public class AuthorityAction {
	private AuthorityDao authorityDao = new AuthorityDao();
	public List<AuthorityBean> selectByPid(int pid) {
		return authorityDao.selectByPid(pid);
	}
	public String selectByAname(String aname){
		return authorityDao.selectByAname(aname);
	}

}
