package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.RoleBean;
import com.zhuoshi.dao.RoleDao;

public class RoleAction {
	private RoleDao roleDao = new RoleDao();
	public List<RoleBean> selectAll() {
		return roleDao.selectAll();
	}
    public String selectById(int id){
    	return roleDao.selectById(id);
	
    }
}