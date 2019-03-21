package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.UserDAO;




public class LoginFrame extends JFrame {

	
	
	
	
	JLabel namelbl=new JLabel("用户名：");
	JLabel passlbl=new JLabel("密    码：");
	JTextField nameTxt=new JTextField();
	JTextField passTxt=new JTextField();
	
	JButton submit=new JButton("登录");
	JButton reset=new JButton("重置");
	JButton register=new JButton("注册");
	
	
	
	
	//构造方法的作用是：初始化对象
	public LoginFrame() 
	{
		
		
		namelbl.setBounds(50, 50, 70, 30);
		passlbl.setBounds(50, 100, 70, 30);
		
		nameTxt.setBounds(140, 50, 150, 30);
		passTxt.setBounds(140, 100, 150, 30);
		
		
		submit.setBounds(20, 150, 70, 30);
		reset.setBounds(100, 150, 70, 30);
		register.setBounds(190, 150, 70, 30);
		//将文本域添加到滚动面板上    然后将滚动面板 添加到  内容面板上
		
		
		this.getContentPane().setLayout(null);
		
		//将组件添加到窗口上(内容面板上)
		this.getContentPane().add(namelbl);
		this.getContentPane().add(nameTxt);
		this.getContentPane().add(submit);
		
		this.getContentPane().add(passlbl);
		this.getContentPane().add(passTxt);
		this.getContentPane().add(reset);
		this.getContentPane().add(register);
		//将滚动面板添加到窗口上
		
		
		this.setSize(400,300);
		this.setTitle("登录");
		
		
		//给按钮添加监听器
		//单击事件
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				mySubmit();
				
			}
		});
		
		
		//给重置按钮添加监听器
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				myReset();
				
			}
		});
		
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				register();
			}
		});
		
		
		
		
		//组件.添加监听器();
		
	
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				myOpen();			
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("最小化");
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("还原");
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("=====");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("关闭");
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("激活窗口");
			}
		});
		
		
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	
	//处理
	public void myOpen()
	{
		this.setTitle("窗口已打开");
	}
	
	//处理重置
	public void myReset()
	{
		this.nameTxt.setText("");
		this.passTxt.setText("");
	}
	
	public void register() 
	{
		new RegisterFrame();
	}
	
	public void mySubmit()
	{
		//获取用户名和密码
		
		String name=this.nameTxt.getText();
		String pass=this.passTxt.getText();
		
		//调用dao层的数据库方法
		UserDAO dao=new UserDAO();
		boolean flag=dao.login(name, pass);
		
		if(flag)
		{
			//关闭当前窗口
			//打开新窗口
			JOptionPane.showMessageDialog(this, "登录成功");
			this.setVisible(false);
			new myJFrame();
		}
		else
		{
			//提示用户 用户名或密码错误
			JOptionPane.showMessageDialog(this, "用户名或密码错误");
		}
	}
	

	
}









