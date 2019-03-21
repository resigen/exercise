package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.dao.BenZhuanDao;

public class BenZhuanAction {
	private  BenZhuanDao benzhuanDao = new  BenZhuanDao();
	
	public int addBenzhuan(BenZhuanBean bean){
		return benzhuanDao.addBenzhuan(bean);
	}
	public int deleteBenzhuan(int id){
		return benzhuanDao.deleteBenzhuan(id);
	}
	public int updateBenzhuan(BenZhuanBean bean){
		return benzhuanDao.updateBenzhuan(bean);
	}
	public BenZhuanBean selectById(int id){
		return benzhuanDao.selectById(id);
	}
	
	public List<BenZhuanBean> selectAll(BenZhuanBean benzhuanBean,int begin,int rowsByPage) {
		List<BenZhuanBean> benzhuans=null;
		if(benzhuanBean==null&&begin==0&&rowsByPage==0)
		{
			benzhuans= benzhuanDao.selectAll();
		}
		if(benzhuanBean!=null&&begin==0&&rowsByPage==0)
		{
			benzhuans = benzhuanDao.selectAll(benzhuanBean);
		}
		if (benzhuanBean == null&&rowsByPage!=0)
		{				
			benzhuans=benzhuanDao.selectAll(begin,rowsByPage);	
		}
		
		return benzhuans;
	}
	public int count() {
		return benzhuanDao.count();
	}
	public int addBenzhuans(List<BenZhuanBean> benzhuans) {
		return benzhuanDao.addBenzhuans(benzhuans);
	}
	
	public int delectallBenzhuans(List<BenZhuanBean> benzhuans) {
		return benzhuanDao.delectallBenzhuans(benzhuans);
	}

}
