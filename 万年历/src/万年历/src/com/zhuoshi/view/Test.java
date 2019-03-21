package com.zhuoshi.view;

import com.zhuoshi.bean.RiZiBean;
import com.zhuoshi.bean.UserBean;

public class Test {
	//static  在内存中一份
	//login 登录页面
	public static LoginFrame login;
	//储存登陆的用户信息
    public static UserBean userBean;
    //存储修学生对话框
    public static UpdateStudentDialog updateStudentDialog; 
    public static UpdateBenZhuanDialog updateBenZhuanDialog;
    public static UpdateShengYuanDialog updateShengYuanDialog;
    public static BenkeShengyuanDialog BenkeShengyuanDialog;
    public static BenkeShengyuanxiangxiDialog benkeShengyuanxiangxiDialog;
    public static DiyiciDialog DiyiciDialog;
    public static updateuserDialog updateUserDialog;
    public static RiZiBean Rb1;
    public static RiZiBean Rb2;
    public static WtXiangxiDialog wtXiangxiDialog;
    public static AddwentiDialog wtaddDialog;
    public static WenTiDialog wtDialog;
	public static void main(String[] args) {
		//启动类
		LoginFrame login = new LoginFrame();
		Test.login=login;
		login.setVisible(true);

	}

}
