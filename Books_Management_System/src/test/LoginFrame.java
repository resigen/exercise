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

	
	
	
	
	JLabel namelbl=new JLabel("�û�����");
	JLabel passlbl=new JLabel("��    �룺");
	JTextField nameTxt=new JTextField();
	JTextField passTxt=new JTextField();
	
	JButton submit=new JButton("��¼");
	JButton reset=new JButton("����");
	JButton register=new JButton("ע��");
	
	
	
	
	//���췽���������ǣ���ʼ������
	public LoginFrame() 
	{
		
		
		namelbl.setBounds(50, 50, 70, 30);
		passlbl.setBounds(50, 100, 70, 30);
		
		nameTxt.setBounds(140, 50, 150, 30);
		passTxt.setBounds(140, 100, 150, 30);
		
		
		submit.setBounds(20, 150, 70, 30);
		reset.setBounds(100, 150, 70, 30);
		register.setBounds(190, 150, 70, 30);
		//���ı�����ӵ����������    Ȼ�󽫹������ ��ӵ�  ���������
		
		
		this.getContentPane().setLayout(null);
		
		//�������ӵ�������(���������)
		this.getContentPane().add(namelbl);
		this.getContentPane().add(nameTxt);
		this.getContentPane().add(submit);
		
		this.getContentPane().add(passlbl);
		this.getContentPane().add(passTxt);
		this.getContentPane().add(reset);
		this.getContentPane().add(register);
		//�����������ӵ�������
		
		
		this.setSize(400,300);
		this.setTitle("��¼");
		
		
		//����ť��Ӽ�����
		//�����¼�
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				mySubmit();
				
			}
		});
		
		
		//�����ð�ť��Ӽ�����
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
		
		
		
		
		//���.��Ӽ�����();
		
	
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				myOpen();			
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��С��");
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ԭ");
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("=====");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�ر�");
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����");
			}
		});
		
		
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	
	//����
	public void myOpen()
	{
		this.setTitle("�����Ѵ�");
	}
	
	//��������
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
		//��ȡ�û���������
		
		String name=this.nameTxt.getText();
		String pass=this.passTxt.getText();
		
		//����dao������ݿⷽ��
		UserDAO dao=new UserDAO();
		boolean flag=dao.login(name, pass);
		
		if(flag)
		{
			//�رյ�ǰ����
			//���´���
			JOptionPane.showMessageDialog(this, "��¼�ɹ�");
			this.setVisible(false);
			new myJFrame();
		}
		else
		{
			//��ʾ�û� �û������������
			JOptionPane.showMessageDialog(this, "�û������������");
		}
	}
	

	
}









