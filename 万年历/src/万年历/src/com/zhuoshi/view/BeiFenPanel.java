package com.zhuoshi.view;

import javax.swing.JPanel;

import com.zhuoshi.tool.DatabaseOperator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.awt.event.ItemEvent;

public class BeiFenPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	JComboBox comboBox = new JComboBox();
	public BeiFenPanel() {
		setLayout(null);

		JButton btnBeiFen = new JButton("\u5907\u4EFD");
		btnBeiFen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatabaseOperator db = new DatabaseOperator();
				String bname = new Date().toLocaleString();
				String burl = System.currentTimeMillis() + ".sql";
				db.backup("mf", "C:\\Users\\admin\\Desktop\\aaa\\", burl, "root", "root");
				JOptionPane.showMessageDialog(null,"备份成功");
			}
		});
		btnBeiFen.setBounds(301, 149, 93, 23);
		add(btnBeiFen);

		JButton butHuanYuan = new JButton("\u8FD8\u539F");
		butHuanYuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = comboBox.getSelectedItem().toString();
				 DatabaseOperator huanyuan = new DatabaseOperator();
				 huanyuan.recover("mf", "C:\\Users\\admin\\Desktop\\aaa\\", url, "root", "root");
					
				 JOptionPane.showMessageDialog(null,"还原成功");
			}
		});
		butHuanYuan.setBounds(39, 149, 93, 23);
		add(butHuanYuan);

		
		try {
			File file = new File("C:\\Users\\admin\\Desktop\\aaa\\");
			File files[] = file.listFiles();
			if (files != null) {
				for (File f : files) {
					if (f.isFile()) {
						comboBox.addItem(f.getName());
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		comboBox.setBounds(98, 39, 222, 41);
		add(comboBox);

	}
}
