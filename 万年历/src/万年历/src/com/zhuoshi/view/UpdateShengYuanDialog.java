package com.zhuoshi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zhuoshi.action.ShengYuanAction;
import com.zhuoshi.bean.ShengYuanBean;
import javax.swing.SwingConstants;

public class UpdateShengYuanDialog extends JDialog {
	private JTextField txtsycode;
	private JTextField txtsyname;

	public UpdateShengYuanDialog(int id) {
		this.setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblsycode = new JLabel("\u751F\u6E90\u5730\u4EE3\u7801");
		lblsycode.setBounds(64, 39, 69, 15);
		getContentPane().add(lblsycode);

		txtsycode = new JTextField();
		txtsycode.setBounds(175, 36, 164, 21);
		getContentPane().add(txtsycode);
		txtsycode.setColumns(10);

		JLabel lblsyname = new JLabel("\u751F\u6E90\u5730\u540D\u79F0");
		lblsyname.setBounds(64, 81, 69, 15);
		getContentPane().add(lblsyname);

		txtsyname = new JTextField();
		txtsyname.setBounds(175, 78, 164, 21);
		getContentPane().add(txtsyname);
		txtsyname.setColumns(10);

		ShengYuanAction actioin = new ShengYuanAction();
		ShengYuanBean bean = actioin.selectById(id);
		txtsycode.setText(bean.getSydcode() + "");
		txtsyname.setText(bean.getSydname());
		
		JButton butUpdate = new JButton("\u4FEE\u6539");
		butUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtsyname.getText();
				String code = txtsycode.getText();
				ShengYuanBean BZbean = new ShengYuanBean();
				BZbean.setSydcode(code);
				BZbean.setSydname(name);
				BZbean.setId(id);
				ShengYuanAction action = new ShengYuanAction();
				int n = action.updateBenzhuan(BZbean);
				if (n > 0) {
					JOptionPane.showMessageDialog(null, "ÐÞ¸Ä³É¹¦");
					Test.updateShengYuanDialog.dispose();
				}
			}
		});
		butUpdate.setBounds(147, 140, 93, 23);
		getContentPane().add(butUpdate);

	}

}
