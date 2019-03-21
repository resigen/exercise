package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.UserDAO;

public class RegisterFrame extends JFrame {
	
	
	JLabel nameLab=new JLabel("用户名");
	JLabel passLab=new JLabel("密码");
	JLabel rePassLab=new JLabel("确认密码");
	JLabel ageLab=new JLabel("年龄");
	JLabel addressLab=new JLabel("地址");
	
	
	JTextField nameTxt=new JTextField();
	JTextField passTxt=new JTextField();
	JTextField rePassTxt=new JTextField();
	JTextField ageTxt=new JTextField();
	JTextField addressTxt=new JTextField();
	
	
	JButton submit=new JButton("注册");
	JButton reset=new JButton("重置");
	
	public RegisterFrame()
	{
		this.getContentPane().setLayout(null);
		
		nameLab.setBounds(10, 10, 60, 30);
		passLab.setBounds(10, 50, 60, 30);
		rePassLab.setBounds(10, 90, 60, 30);
		ageLab.setBounds(10, 130, 60, 30);
		addressLab.setBounds(10, 170, 60, 30);
		
		
		
		nameTxt.setBounds(80, 10, 160, 30);
		passTxt.setBounds(80, 50, 160, 30);
		rePassTxt.setBounds(80, 90, 160, 30);
		ageTxt.setBounds(80, 130, 160, 30);
		addressTxt.setBounds(80, 170, 160, 30);
		
		
		submit.setBounds(40, 210, 60, 30);
		reset.setBounds(110, 210, 60, 30);
		
		
		
		this.getContentPane().add(nameLab);
		this.getContentPane().add(passLab);
		this.getContentPane().add(rePassLab);
		this.getContentPane().add(ageLab);
		this.getContentPane().add(addressLab);
		
		
		this.getContentPane().add(nameTxt);
		this.getContentPane().add(passTxt);
		this.getContentPane().add(rePassTxt);
		this.getContentPane().add(ageTxt);
		this.getContentPane().add(addressTxt);
		
		this.getContentPane().add(submit);
		this.getContentPane().add(reset);
		
		
		
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				register();
				
			}
		});

		reset.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				myReset();
				
			}
		});
			
		
		
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void register()
	{
		
		
		
		
		String name=nameTxt.getText();
		String pass=passTxt.getText();
		String rePass=rePassTxt.getText();
		String address=addressTxt.getText();
		
		
		//验证代码
		
		//验证是否有表单没有填写
		if(name.equals("") || pass.equals("") || rePass.equals("") || ageTxt.getText().equals("") || address.equals("") )
		{
			JOptionPane.showMessageDialog(this, "表单数据必须填写完整", "注册失败", JOptionPane.WARNING_MESSAGE);
			return;
		}
		//两次密码是否一致
		if(! pass.equals(rePass))
		{
			JOptionPane.showMessageDialog(this, "两次密码必须一致", "注册失败", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//
		
		int age=Integer.parseInt(ageTxt.getText());
		
		
		UserDAO dao=new UserDAO();
		boolean flag=dao.add(name, pass, age, address);
		
		
		if(flag)
		{
			this.setVisible(false);
			new LoginFrame();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "注册失败", "注册失败", JOptionPane.ERROR_MESSAGE);
		}
		//获取文本框的值
		//调用数据库方法 添加用户
		//判断结果
	}
	
	
	public void myReset()
	{
		nameTxt.setText("");
		passTxt.setText("");
		rePassTxt.setText("");
		ageTxt.setText("");
		addressTxt.setText("");
	}
	
	
	

}
