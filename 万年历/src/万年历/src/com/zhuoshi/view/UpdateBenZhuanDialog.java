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

import com.zhuoshi.action.BenZhuanAction;
import com.zhuoshi.bean.BenZhuanBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateBenZhuanDialog extends JDialog {
	private JTextField txtzycode;
	private JTextField txtzyname;

	public UpdateBenZhuanDialog(int id) {
		this.setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblzycode = new JLabel("\u4E13\u4E1A\u4EE3\u7801");
		lblzycode.setBounds(79, 39, 54, 15);
		getContentPane().add(lblzycode);

		txtzycode = new JTextField();
		txtzycode.setBounds(175, 36, 164, 21);
		getContentPane().add(txtzycode);
		txtzycode.setColumns(10);

		JLabel lblzyname = new JLabel("\u4E13\u4E1A\u540D\u79F0");
		lblzyname.setBounds(79, 81, 54, 15);
		getContentPane().add(lblzyname);

		txtzyname = new JTextField();
		txtzyname.setBounds(175, 78, 164, 21);
		getContentPane().add(txtzyname);
		txtzyname.setColumns(10);

		BenZhuanAction actioin = new BenZhuanAction();
		BenZhuanBean bean = actioin.selectById(id);
		txtzycode.setText(bean.getBzzycode() + "");
		txtzyname.setText(bean.getBzzyname());
		
		JButton butUpdate = new JButton("\u4FEE\u6539");
		butUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtzyname.getText();
				String code = txtzycode.getText();
				BenZhuanBean BZbean = new BenZhuanBean();
				BZbean.setBzzycode(code);
				BZbean.setBzzyname(name);
				BZbean.setId(id);
				BenZhuanAction action = new BenZhuanAction();
				int n = action.updateBenzhuan(BZbean);
				if (n > 0) {
					JOptionPane.showMessageDialog(null, "ÐÞ¸Ä³É¹¦");
					Test.updateBenZhuanDialog.dispose();
				}
			}
		});
		butUpdate.setBounds(147, 140, 93, 23);
		getContentPane().add(butUpdate);

	}

}
