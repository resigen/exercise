package com.zhuoshi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zhuoshi.action.BenZhuanAction;
import com.zhuoshi.action.StudentAction;
import com.zhuoshi.action.UserAction;
import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.bean.UserBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiyiciDialog extends JDialog {
	private JTextField txtusername;
	private JTextField txtnewpassword;
	private JTextField txtokmima;

	public DiyiciDialog(int id) {
		this.setModal(true);
		setBounds(100, 100,500,400);
		getContentPane().setLayout(null);
		
		JLabel lblusername = new JLabel("\u7528\u6237\u540D");
		lblusername.setBounds(92, 95, 54, 15);
		getContentPane().add(lblusername);
		
		txtusername = new JTextField();
		txtusername.setBounds(167, 92, 205, 21);
		getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblnewpassword = new JLabel("\u65B0\u5BC6\u7801");
		lblnewpassword.setBounds(92, 155, 54, 15);
		getContentPane().add(lblnewpassword);
		
		txtnewpassword = new JTextField();
		txtnewpassword.setBounds(167, 152, 205, 21);
		getContentPane().add(txtnewpassword);
		txtnewpassword.setColumns(10);
		
		JLabel lblokmima = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblokmima.setBounds(92, 216, 54, 15);
		getContentPane().add(lblokmima);
		
		txtokmima = new JTextField();
		txtokmima.setBounds(167, 213, 205, 21);
		getContentPane().add(txtokmima);
		txtokmima.setColumns(10);
		
		JButton butqueding = new JButton("\u786E\u5B9A");
		butqueding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newpassword = txtnewpassword.getText();
				int id=Test.userBean.getId();
				if (newpassword.equals(txtokmima.getText())) {
					UserBean usenewbean = new UserBean();
					usenewbean.setNewpassword(newpassword);
					usenewbean.setId(id);
					UserAction newaction = new UserAction();
					int n = newaction.updateUserpassword(usenewbean);
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "修改成功");
						Test.DiyiciDialog.dispose();

					}
				} else {
					JOptionPane.showMessageDialog(null, "密码不一致");
				}
			}
		});
		butqueding.setBounds(176, 286, 93, 23);
		getContentPane().add(butqueding);
		
		JLabel lblNewLabel = new JLabel("\u9996\u6B21\u767B\u5F55\uFF0C\u8BF7\u4FEE\u6539\u5BC6\u7801\uFF01\uFF01\uFF01");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(111, 28, 292, 32);
		getContentPane().add(lblNewLabel);
		
		UserAction actioin = new UserAction();
		UserBean bean = actioin.selectById(id);
		txtusername.setText(bean.getUsername());
		txtnewpassword.setText(bean.getPassword());
		txtokmima.setText(bean.getPassword());
       
		
	}
}
