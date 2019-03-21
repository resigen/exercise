package com.zhuoshi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zhuoshi.action.WJAction;
import com.zhuoshi.bean.WJBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddwentiDialog extends JDialog {
	private JTextField txtwenti;
	private JTextField txtdaan1;
	private JTextField txtdaan2;
	private JTextField txtdaan3;

	
	public AddwentiDialog() {
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
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WJBean wb= new WJBean();
				wb.setWenti(txtwenti.getText());
				wb.setDaan1(txtdaan1.getText());
				wb.setDaan2(txtdaan2.getText());
				wb.setDaan3(txtdaan3.getText());
				WJAction wenta =new WJAction();
				int n =wenta.addwenti(wb);
				if(n>0){
					JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
					Test.wtaddDialog.dispose();
				}
			
			}
		});
		button.setBounds(188, 297, 93, 23);
		getContentPane().add(button);
		
		
		
	}

}
