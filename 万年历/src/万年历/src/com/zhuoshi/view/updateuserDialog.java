package com.zhuoshi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zhuoshi.action.BenkeShengyuanAction;
import com.zhuoshi.action.UserAction;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.UserBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateuserDialog extends JDialog {
	private JTextField txtname;
	private JTextField txtnewpassword;
	private JTextField txtokpassword;


	public updateuserDialog(int id) {
		this.setModal(true);
		setBounds(100, 100,500,400);
		getContentPane().setLayout(null);
		
		JLabel lblname = new JLabel("\u7528\u6237\u540D");
		lblname.setBounds(83, 92, 54, 15);
		getContentPane().add(lblname);
		
		JLabel lblnewpassword = new JLabel("\u65B0\u5BC6\u7801");
		lblnewpassword.setBounds(83, 150, 54, 15);
		getContentPane().add(lblnewpassword);
		
		JLabel lblokpassword = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblokpassword.setBounds(83, 216, 54, 15);
		getContentPane().add(lblokpassword);
		
		txtname = new JTextField();
		txtname.setBounds(178, 89, 191, 21);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtnewpassword = new JTextField();
		txtnewpassword.setBounds(178, 147, 191, 21);
		getContentPane().add(txtnewpassword);
		txtnewpassword.setColumns(10);
		
		txtokpassword = new JTextField();
		txtokpassword.setBounds(178, 213, 191, 21);
		getContentPane().add(txtokpassword);
		txtokpassword.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newpassword = txtnewpassword.getText();
				if (newpassword.equals(txtokpassword.getText())) {
					UserBean usenewbean = new UserBean();
					usenewbean.setNewpassword(newpassword);
					usenewbean.setId(id);
					UserAction newaction = new UserAction();
					int n = newaction.updateUserpassword(usenewbean);
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "修改成功");
						Test.updateUserDialog.dispose();

					}
				} else {
					JOptionPane.showMessageDialog(null, "密码不一致");
				}
				
			}
		});
		button.setBounds(181, 281, 93, 23);
		getContentPane().add(button);
		
		UserAction actioin = new UserAction();
		UserBean bean = actioin.selectById(id);
	    txtname.setText(bean.getUsername());
	    txtnewpassword.setText(bean.getPassword());
	    txtokpassword.setText(bean.getPassword());


	}
}
