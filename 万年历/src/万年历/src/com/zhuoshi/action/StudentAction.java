package com.zhuoshi.action;

import java.util.List;

import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.dao.RoleDao;
import com.zhuoshi.dao.StudentDao;

public class StudentAction {
	private  StudentDao studentDao = new  StudentDao();
	public int addStudent(StudentBean bean){
		return studentDao.addStudent(bean);
	}
	public int deleteStudent(int id){
		return studentDao.deleteStudent(id);
	}
	public int updateStudent(StudentBean bean){
		return studentDao.updateStudent(bean);
	}
	public StudentBean selectById(int id){
		return studentDao.selectById(id);
	}
//	public List<StudentBean> selectAll(){
//		return studentDao.selectAll();
//	}
//	//Ìõ¼þ²éÑ¯
//	public List<StudentBean> selectAll(StudentBean studentBean){
//		return studentDao.selectAll(studentBean);
//	}
//	public List<StudentBean> selectAll(int begin,int rowsByPage) {
//		return studentDao.selectAll(begin, rowsByPage);
//	}
	public List<StudentBean> selectAll(StudentBean studentBean,int begin,int rowsByPage) {
		List<StudentBean> students=null;
		if(studentBean==null&&begin==0&&rowsByPage==0)
		{
			students= studentDao.selectAll();
		}
		if(studentBean!=null&&begin==0&&rowsByPage==0)
		{
			students= studentDao.selectAll(studentBean);
		}
		if (studentBean == null&&rowsByPage!=0)
		{				
			students=studentDao.selectAll(begin,rowsByPage);	
		}
		
		return students;
	}
	public int count() {
		return studentDao.count();
	}
	public int addStudents(List<StudentBean> students) {
		return studentDao.addStudents(students);
	}
	
	
	
	

}
