package com.zhuoshi.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.zhuoshi.action.UserAction;
import com.zhuoshi.bean.UserBean;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XiugaimimaPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;


	public XiugaimimaPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel.setBounds(86, 90, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_1.setBounds(86, 155, 54, 15);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newpassword = textField.getText();
				int id = Test.userBean.getId();
					
					if (newpassword.equals(textField_1.getText())) {
						UserBean usenewbean = new UserBean();
						usenewbean.setNewpassword(newpassword);
						usenewbean.setId(id);
						UserAction newaction = new UserAction();
						int n = newaction.updateUserpassword(usenewbean);
						if (n > 0) {
							JOptionPane.showMessageDialog(null, "修改成功");
						}
					}else{
						JOptionPane.showMessageDialog(null, "密码不一致");
					}				
			}
		});
		btnNewButton.setBounds(166, 234, 93, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(166, 87, 153, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(166, 152, 153, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(185, 36, 153, 23);
		add(lblNewLabel_2);

	}
}
