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
	
	
	JLabel nameLab=new JLabel("�û���");
	JLabel passLab=new JLabel("����");
	JLabel rePassLab=new JLabel("ȷ������");
	JLabel ageLab=new JLabel("����");
	JLabel addressLab=new JLabel("��ַ");
	
	
	JTextField nameTxt=new JTextField();
	JTextField passTxt=new JTextField();
	JTextField rePassTxt=new JTextField();
	JTextField ageTxt=new JTextField();
	JTextField addressTxt=new JTextField();
	
	
	JButton submit=new JButton("ע��");
	JButton reset=new JButton("����");
	
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
		
		
		//��֤����
		
		//��֤�Ƿ��б�û����д
		if(name.equals("") || pass.equals("") || rePass.equals("") || ageTxt.getText().equals("") || address.equals("") )
		{
			JOptionPane.showMessageDialog(this, "�����ݱ�����д����", "ע��ʧ��", JOptionPane.WARNING_MESSAGE);
			return;
		}
		//���������Ƿ�һ��
		if(! pass.equals(rePass))
		{
			JOptionPane.showMessageDialog(this, "�����������һ��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(this, "ע��ʧ��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
		}
		//��ȡ�ı����ֵ
		//�������ݿⷽ�� ����û�
		//�жϽ��
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
