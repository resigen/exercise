package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.booklistDAO;

public class updateFrame extends JFrame {
	JLabel idLab=new JLabel("���");
	JLabel nameLab=new JLabel("����");
	JLabel priceLab=new JLabel("�۸�");
	JLabel authLab=new JLabel("����");
	JLabel pub_dateLab=new JLabel("����ʱ��");
	JLabel pressLab=new JLabel("������");
	JLabel statesLab=new JLabel("�Ƿ���");
	
	JTextField idTxt=new JTextField();
	JTextField nameTxt=new JTextField();
	JTextField priceTxt=new JTextField();
	JTextField authTxt=new JTextField();
	JTextField pub_dateTxt=new JTextField();
	JTextField pressTxt=new JTextField();
	JTextField statesTxt=new JTextField();
	
	JButton update=new JButton("�޸�");
	
	public updateFrame()
	{
		this.getContentPane().setLayout(null);
		
		idLab.setBounds(10, 10, 60, 30);
		nameLab.setBounds(10, 50, 60, 30);
		priceLab.setBounds(10, 90, 60, 30);
		authLab.setBounds(10, 130, 60, 30);
		pub_dateLab.setBounds(10, 170, 60, 30);
		pressLab.setBounds(10, 210, 60, 30);
	    statesLab.setBounds(10, 240, 60, 30);
		
		
		
		idTxt.setBounds(80, 10, 160, 30);
		nameTxt.setBounds(80, 50, 160, 30);
		priceTxt.setBounds(80, 90, 160, 30);
		authTxt.setBounds(80, 130, 160, 30);
		pub_dateTxt.setBounds(80, 170, 160, 30);
		pressTxt.setBounds(80, 210, 160, 30);
		statesTxt.setBounds(80, 240, 160, 30);
		
		update.setBounds(40, 270, 60, 30);
		
		this.getContentPane().add(idLab);
		this.getContentPane().add(nameLab);
		this.getContentPane().add(priceLab);
		this.getContentPane().add(authLab);
		this.getContentPane().add(pub_dateLab);
		this.getContentPane().add(pressLab);
		
		
		
		this.getContentPane().add(idTxt);
		this.getContentPane().add(nameTxt);
		this.getContentPane().add(priceTxt);
		this.getContentPane().add(authTxt);
		this.getContentPane().add(pub_dateTxt);
		this.getContentPane().add(pressTxt);
		
		
		this.getContentPane().add(update);
		
		this.setSize(300, 400);
		this.setVisible(true);
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				update();
			}
		});
}
	public void update() 
	{
		int id = Integer.parseInt(idTxt.getText());
		String name=nameTxt.getText();
		String price=priceTxt.getText();
		String auth=authTxt.getText();
		String pub_date=pub_dateTxt.getText();
		String press=pressTxt.getText();
		
		//��֤����
		
		//��֤�Ƿ��б�û����д
		if(name.equals("") || price.equals("") || auth.equals("") || pub_date.equals("") || press.equals("") )
		{
			JOptionPane.showMessageDialog(this, "�����ݱ�����д����", "���ʧ��", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		
		
		booklistDAO book=new booklistDAO();
		boolean flag=book.update(name, price, auth, pub_date,press,id);
		
		
		if(flag)
		{
			this.setVisible(false);
			JOptionPane.showMessageDialog(this, "�޸ĳɹ�", "�޸ĳɹ�", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "�޸�ʧ��", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
		}
		//��ȡ�ı����ֵ
		//�������ݿⷽ�� ����û�
		//�жϽ��
	}

	}
