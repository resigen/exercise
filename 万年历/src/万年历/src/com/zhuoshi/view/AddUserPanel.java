package com.zhuoshi.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.zhuoshi.action.BenkeShengyuanAction;
import com.zhuoshi.action.UserAction;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.UserBean;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddUserPanel extends JPanel {
	private JTextField txtname;
	private JTextField txtpassword;
	private JTextField txtokmiam;
	private Choice cobjuese;

	/**
	 * Create the panel.
	 */
	public AddUserPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u7528\u6237");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(223, 38, 107, 36);
		add(label);
		
		cobjuese = new Choice();
		cobjuese.add("学生");
		cobjuese.add("辅导员");
		cobjuese.add("就业指导中心");
		cobjuese.add("管理员");
		cobjuese.setBounds(100, 102, 107, 21);
		add(cobjuese);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0");
		lblNewLabel.setBounds(61, 108, 33, 15);
		add(lblNewLabel);
		
		JLabel lblname = new JLabel("\u7528\u6237\u540D");
		lblname.setBounds(119, 169, 54, 15);
		add(lblname);
		
		txtname = new JTextField();
		txtname.setBounds(211, 166, 152, 21);
		add(txtname);
		txtname.setColumns(10);
		
		JLabel lblpassword = new JLabel("\u5BC6\u7801");
		lblpassword.setBounds(119, 239, 54, 15);
		add(lblpassword);
		
		JLabel lblokmima = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblokmima.setBounds(119, 311, 54, 15);
		add(lblokmima);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(211, 239, 152, 21);
		add(txtpassword);
		txtpassword.setColumns(10);
		
		txtokmiam = new JTextField();
		txtokmiam.setBounds(211, 308, 152, 21);
		add(txtokmiam);
		txtokmiam.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtpassword.getText().equals("") && !txtokmiam.getText().equals("") && !txtname.getText().equals("")) {
					if (txtpassword.getText().equals(txtokmiam.getText())) {
						String str = cobjuese.getSelectedItem();
						UserBean bean = new UserBean();
						bean.setJuese(str);
						bean.setPassword(txtpassword.getText());
						bean.setUsername(txtname.getText());
						UserAction action = new UserAction();
						int k = action.addUser(bean);
						if (k > 0) {
							JOptionPane.showMessageDialog(null, "添加成功");
						}
					} else {
						JOptionPane.showMessageDialog(null, "密码不一致");
					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入信息");
				}
			}
		});
		button.setBounds(205, 389, 93, 23);
		add(button);

	}
}
