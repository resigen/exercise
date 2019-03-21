package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.WJBean;
import com.zhuoshi.dao.WJDao;

public class WJAction {
	WJDao wenjuan =new WJDao();
	
	public List<WJBean> selectAll() {
		return wenjuan.selectAll();
	}
	public WJBean selectById(int id) {
		return wenjuan.selectById(id);
	}
	public int updatefabu(int id) {
		return wenjuan.updatefabu(id);
	}
	public int deletewenti(int id) {
		return wenjuan.deletewenti(id);
	}
	public int addwenti(WJBean bean) {
		return wenjuan.addwenti(bean);
	}
	public List<WJBean> selectAllbyfabu() {
		return wenjuan.selectAllbyfabu();
	}

}
