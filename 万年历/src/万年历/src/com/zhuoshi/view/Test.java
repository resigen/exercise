package com.zhuoshi.view;

import com.zhuoshi.bean.RiZiBean;
import com.zhuoshi.bean.UserBean;

public class Test {
	//static  ���ڴ���һ��
	//login ��¼ҳ��
	public static LoginFrame login;
	//�����½���û���Ϣ
    public static UserBean userBean;
    //�洢��ѧ���Ի���
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
		//������
		LoginFrame login = new LoginFrame();
		Test.login=login;
		login.setVisible(true);

	}

}
