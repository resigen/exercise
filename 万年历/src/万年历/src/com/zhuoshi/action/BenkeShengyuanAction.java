package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.dao.BenkeShengyuanDao;

public class BenkeShengyuanAction {
private  BenkeShengyuanDao benkeDao = new  BenkeShengyuanDao();
	
public int addBenkesy(BenkeShengyuanBean bean) {
		return benkeDao.addBenkesy(bean);
	}
	public int deleteBenkesy(int id){
		return benkeDao.deleteBenkesy(id);
	}
	public int updateBenkesy(BenkeShengyuanBean bean){
		return benkeDao.updateBenkesy(bean);
	}
	public int updateBksy(BenkeShengyuanBean bean){
		return benkeDao.updateBksy(bean);
	}
	
	public BenkeShengyuanBean selectById(int id){
		return benkeDao.selectById(id);
	}
	
	public List<BenkeShengyuanBean> selectAll(BenkeShengyuanBean BenkeShengyuanBean,int begin,int rowsByPage) {
		List<BenkeShengyuanBean> benzhuans=null;
		if(BenkeShengyuanBean==null&&begin==0&&rowsByPage==0)
		{
			benzhuans= benkeDao.selectAll();
		}
		if(BenkeShengyuanBean!=null&&begin==0&&rowsByPage==0)
		{
			benzhuans = benkeDao.selectAll(BenkeShengyuanBean);
		}
		if (BenkeShengyuanBean == null&&rowsByPage!=0)
		{				
			benzhuans=benkeDao.selectAll(begin,rowsByPage);	
		}
		
		return benzhuans;
	}
	public int count() {
		return benkeDao.count();
	}
	public int  addAllBenkesys(List<BenkeShengyuanBean> benzhuans) {
		return benkeDao. addAllBenkesys(benzhuans);
	}
	
	public int delectallBenkesys(List<BenkeShengyuanBean> benzhuans) {
		return benkeDao.delectallBenkesys(benzhuans);
	}

	public List<BenkeShengyuanBean> selectAllbyid(List<Integer> ids) {

		return benkeDao.selectAllbyid(ids);
	}
	public List<BenkeShengyuanBean> selectallzhuanye() {
		return benkeDao.selectallzhuanye();
	}
	public List<BenkeShengyuanBean> selectashengyuandi() {
		return benkeDao.selectashengyuandi();
	}
//	public List<BenkeShengyuanBean> selectzhuanyecount() {
//		return benkeDao.selectzhuanyecount();
//	}
//	public List<BenkeShengyuanBean> selectshengYDcount() {
//		return benkeDao.selectshengYDcount();		
//	}
//	public List<BenkeShengyuanBean> selectCount(BenkeShengyuanBean zhuanYs) {
//		return benkeDao.selectCount(zhuanYs);
//	}
	public int selectCount(String zhuanye,String diqu) {
		return benkeDao.selectCount(zhuanye, diqu);
	}
}
