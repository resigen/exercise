package com.zhuoshi.view;

import java.util.Date;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zhuoshi.action.RoleAction;
import com.zhuoshi.action.UserAction;
import com.zhuoshi.action.WJAction;
import com.zhuoshi.bean.RiZiBean;
import com.zhuoshi.bean.RoleBean;
import com.zhuoshi.bean.UserBean;
import com.zhuoshi.bean.WJBean;
import com.zhuoshi.dao.UserDao;
import com.zhuoshi.tool.ValidCode;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import java.awt.Font;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtYanZhengMa;
	private ValidCode vcode;
	private JLabel lb_backgroud;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {

		setTitle("\u5927\u5B66\u751F\u5C31\u4E1A\u7BA1\u7406\u7CFB\u7EDF\u5E73\u53F0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		setSize(450, 360);
		// setLocationRelativeTo(null);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - getWidth()) / 2);
		int y = (int) ((screen.getHeight() - getHeight()) / 2);
		setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		vcode = new ValidCode();
		vcode.setBounds(241, 201, 93, 40);
		contentPane.add(vcode);

		JLabel lblUsername = new JLabel("\u7528\u6237\u540D");
		lblUsername.setBounds(88, 85, 54, 15);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(152, 79, 183, 21);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setText("admin");

		JLabel lblPasswprd = new JLabel("\u5BC6\u7801");
		lblPasswprd.setHorizontalAlignment(SwingConstants.LEFT);
		lblPasswprd.setBounds(88, 126, 54, 15);
		contentPane.add(lblPasswprd);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(152, 123, 183, 21);
		contentPane.add(txtPassword);
		txtPassword.setText("admin");

		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setBounds(230, 251, 93, 23);
		contentPane.add(btnCancel);

		JLabel lblRole = new JLabel("\u89D2\u8272");
		lblRole.setBounds(88, 163, 54, 15);
		contentPane.add(lblRole);

		JComboBox cboRole = new JComboBox();
		cboRole.setBounds(152, 160, 183, 21);
		contentPane.add(cboRole);
		RoleAction roleAction = new RoleAction();
		List<RoleBean> roles = roleAction.selectAll();
		for (RoleBean role : roles) {
			cboRole.addItem(role.getRolename());
		}

		JButton btnEnter = new JButton("\u767B\u5F55");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!isValidCodeRight()) {
					JOptionPane.showMessageDialog(LoginFrame.this, "验证码错误！");
				}
				if (isValidCodeRight()) {
					String username = txtUsername.getText();
					String password = txtPassword.getText();
					UserBean bean = new UserBean();
					bean.setUsername(username);
					bean.setPassword(password);
					UserAction action = new UserAction();
					UserBean userBean = action.login(bean);
					if (action.login(bean) == null) {
						JOptionPane.showMessageDialog(null, "错误的用户名或密码");
					} else {
						RoleAction roleaction = new RoleAction();
						String rolename = roleAction.selectById(userBean.getRid());
						if (cboRole.getSelectedItem().toString().equals(rolename)) {
							Test.userBean = userBean;
							Test.login.dispose();
							if (userBean.getDenglucishu() == 0) {
								DiyiciDialog first = new DiyiciDialog(userBean.getId());
								Test.DiyiciDialog = first;
								first.setVisible(true);

								UserBean ubean = new UserBean();
								ubean.setId(userBean.getId());
								ubean.setDenglucishu(userBean.getDenglucishu() + 1);
								UserAction useaction = new UserAction();
								useaction.updateUserDenglucishu(ubean);

								LoginFrame lf = new LoginFrame();
								Test.login = lf;
								lf.setVisible(true);

							} else if (userBean.getDenglucishu() == 1) {
								WJAction wa = new WJAction();
								List<WJBean> wb = wa.selectAllbyfabu();
								if (wb.size() > 0) {
									for (WJBean w : wb) {
										WenTiDialog wdialog = new WenTiDialog(w);
										Test.wtDialog = wdialog;
										wdialog.setVisible(true);
									}
									// Test.wtDialog.dispose();
									UserBean ubean = new UserBean();
									ubean.setId(userBean.getId());
									ubean.setDenglucishu(userBean.getDenglucishu() + 1);
									UserAction useaction = new UserAction();
									useaction.updateUserDenglucishu(ubean);

									// 登录时间
									Date day = new Date();
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									// System.out.println(df.format(day));
									RiZiBean Rb1 = new RiZiBean();
									Rb1.setUsername(Test.userBean.getUsername());
									Rb1.setCometime(df.format(day));
									Test.Rb1 = Rb1;

									MainFrame frame = new MainFrame();
									frame.setVisible(true);
								} else {
									UserBean ubean = new UserBean();
									ubean.setId(userBean.getId());
									ubean.setDenglucishu(userBean.getDenglucishu() + 1);
									UserAction useaction = new UserAction();
									useaction.updateUserDenglucishu(ubean);
									MainFrame frame = new MainFrame();
									// 登录时间
									Date day = new Date();
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									// System.out.println(df.format(day));
									RiZiBean Rb1 = new RiZiBean();
									Rb1.setUsername(Test.userBean.getUsername());
									Rb1.setCometime(df.format(day));
									Test.Rb1 = Rb1;

									frame.setVisible(true);
								}

							} else {
								UserBean ubean = new UserBean();
								ubean.setId(userBean.getId());
								ubean.setDenglucishu(userBean.getDenglucishu() + 1);
								UserAction useaction = new UserAction();
								useaction.updateUserDenglucishu(ubean);
								MainFrame frame = new MainFrame();
								// 登录时间
								Date day = new Date();
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								// System.out.println(df.format(day));
								RiZiBean Rb1 = new RiZiBean();
								Rb1.setUsername(Test.userBean.getUsername());
								Rb1.setCometime(df.format(day));
								Test.Rb1 = Rb1;

								frame.setVisible(true);
							}
						} else {
							JOptionPane.showMessageDialog(null, "该用户不具有这个角色");
						}
					}
				}
			}
		});
		btnEnter.setBounds(91, 251, 93, 23);
		contentPane.add(btnEnter);

		JLabel lblYanZhengMa = new JLabel("\u9A8C\u8BC1\u7801");
		lblYanZhengMa.setBounds(88, 208, 54, 15);
		contentPane.add(lblYanZhengMa);

		txtYanZhengMa = new JTextField();
		txtYanZhengMa.setBounds(152, 201, 90, 40);
		contentPane.add(txtYanZhengMa);
		txtYanZhengMa.setColumns(10);

		JLabel lblTop = new JLabel("\u5927\u5B66\u751F\u5C31\u4E1A\u7BA1\u7406\u7CFB\u7EDF");
		lblTop.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblTop.setBounds(112, 22, 250, 35);
		contentPane.add(lblTop);

		((JPanel) this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("img/bg.jpg"); // 添加图片
		lb_backgroud = new JLabel(img);
		this.getLayeredPane().add(lb_backgroud, new Integer(Integer.MIN_VALUE));
		lb_backgroud.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		contentPane.add(lb_backgroud);

	}

	public boolean isValidCodeRight() {

		if (txtYanZhengMa == null) {
			return false;
		}
		if (vcode == null) {
			return true;
		}
		if (vcode.getCode().equalsIgnoreCase(txtYanZhengMa.getText())) {
			return true;
		}
		return false;
	}
}
