package com.zhuoshi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zhuoshi.action.UserAction;
import com.zhuoshi.action.WJAction;
import com.zhuoshi.bean.UserBean;
import com.zhuoshi.bean.WJBean;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class WtXiangxiDialog extends JDialog {
	private JTextField txtwenti;
	private JTextField txtdaan1;
	private JTextField txtdaan2;
	private JTextField txtdaan3;

	public WtXiangxiDialog(int id) {
		this.setModal(true);
		setBounds(100, 100,500,400);
		getContentPane().setLayout(null);
		
		JLabel lblwenti = new JLabel("\u95EE\u9898");
		lblwenti.setBounds(47, 71, 54, 15);
		getContentPane().add(lblwenti);
		
		JLabel lbldaan1 = new JLabel("\u7B54\u6848\u4E00");
		lbldaan1.setBounds(47, 133, 54, 15);
		getContentPane().add(lbldaan1);
		
		JLabel lbldaan2 = new JLabel("\u7B54\u6848\u4E8C");
		lbldaan2.setBounds(47, 191, 54, 15);
		getContentPane().add(lbldaan2);
		
		JLabel lbldaan3 = new JLabel("\u7B54\u6848\u4E09");
		lbldaan3.setBounds(47, 243, 54, 15);
		getContentPane().add(lbldaan3);
		
		txtwenti = new JTextField();
		txtwenti.setBounds(132, 68, 264, 21);
		getContentPane().add(txtwenti);
		txtwenti.setColumns(10);
		
		txtdaan1 = new JTextField();
		txtdaan1.setBounds(132, 130, 264, 21);
		getContentPane().add(txtdaan1);
		txtdaan1.setColumns(10);
		
		txtdaan2 = new JTextField();
		txtdaan2.setBounds(132, 188, 264, 21);
		getContentPane().add(txtdaan2);
		txtdaan2.setColumns(10);
		
		txtdaan3 = new JTextField();
		txtdaan3.setBounds(132, 240, 264, 21);
		getContentPane().add(txtdaan3);
		txtdaan3.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setBounds(188, 297, 93, 23);
		getContentPane().add(button);
		
		WJAction actioin = new WJAction();
		WJBean bean = actioin.selectById(id);
		txtwenti.setText(bean.getWenti());
		txtdaan1.setText(bean.getDaan1());
		txtdaan2.setText(bean.getDaan2());
		txtdaan3.setText(bean.getDaan3());
		
	}

}
