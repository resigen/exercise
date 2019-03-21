package com.zhuoshi.view;

import java.awt.Choice;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.zhuoshi.action.BenkeShengyuanAction;
import com.zhuoshi.action.UserAction;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.UserBean;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XianshiXueshengPanel extends JPanel {
	private JTextField txtkaoshenghao;
	private JTextField txtminzu;
	private JTextField txtname;
	private JTextField txtxuehao;
	private JTextField txtnianji;
	private JTextField txtzhengzhimianmao;
	private JTextField txtxueli;
	private JTextField txtzhuanye;
	private JTextField txtshenfenzheng;
	private JTextField txtyingyudengji;
	private JTextField txtlianxidianhua;
	private JTextField txtjiangcheng;
	private JTextField txtxueyuan;
	private Choice Xuezhi;

	/**
	 * Create the panel.
	 */
	public XianshiXueshengPanel() {
		this.setLayout(null);

		JLabel lblkaoshihao = new JLabel("\u8003\u751F\u53F7");
		lblkaoshihao.setBounds(30, 64, 49, 15);
		add(lblkaoshihao);

		txtkaoshenghao = new JTextField();
		txtkaoshenghao.setBounds(90, 61, 146, 21);
		add(txtkaoshenghao);
		txtkaoshenghao.setColumns(10);

		JLabel lblsex = new JLabel("\u6027\u522B");
		lblsex.setBounds(30, 99, 54, 15);
		add(lblsex);

		JLabel lblxueyuan = new JLabel("\u5B66\u9662");
		lblxueyuan.setBounds(30, 139, 54, 15);
		add(lblxueyuan);

		JLabel lblminzu = new JLabel("\u6C11\u65CF");
		lblminzu.setBounds(30, 187, 54, 15);
		add(lblminzu);

		txtminzu = new JTextField();
		txtminzu.setBounds(90, 184, 146, 21);
		add(txtminzu);
		txtminzu.setColumns(10);

		JLabel lblname = new JLabel("\u59D3\u540D");
		lblname.setBounds(316, 64, 41, 15);
		add(lblname);

		txtname = new JTextField();
		txtname.setBounds(384, 61, 128, 21);
		add(txtname);
		txtname.setColumns(10);

		JLabel lblxuehao = new JLabel("\u5B66\u53F7");
		lblxuehao.setBounds(316, 99, 41, 15);
		add(lblxuehao);

		txtxuehao = new JTextField();
		txtxuehao.setBounds(384, 96, 128, 21);
		add(txtxuehao);
		txtxuehao.setColumns(10);

		JLabel lblnianji = new JLabel("\u5E74\u7EA7");
		lblnianji.setBounds(316, 139, 34, 15);
		add(lblnianji);

		txtnianji = new JTextField();
		txtnianji.setBounds(384, 136, 128, 21);
		add(txtnianji);
		txtnianji.setColumns(10);

		JLabel lblzhengzhimianmao = new JLabel("\u653F\u6CBB\u9762\u8C8C");
		lblzhengzhimianmao.setBounds(316, 187, 54, 15);
		add(lblzhengzhimianmao);

		txtzhengzhimianmao = new JTextField();
		txtzhengzhimianmao.setBounds(384, 184, 128, 21);
		add(txtzhengzhimianmao);
		txtzhengzhimianmao.setColumns(10);

		JLabel lblxueli = new JLabel("\u5B66\u5386");
		lblxueli.setBounds(30, 234, 41, 15);
		add(lblxueli);

		txtxueli = new JTextField();
		txtxueli.setBounds(90, 231, 146, 21);
		add(txtxueli);
		txtxueli.setColumns(10);

		JLabel lblzhuanye = new JLabel("\u4E13\u4E1A");
		lblzhuanye.setBounds(316, 234, 54, 15);
		add(lblzhuanye);

		txtzhuanye = new JTextField();
		txtzhuanye.setBounds(384, 231, 128, 21);
		add(txtzhuanye);
		txtzhuanye.setColumns(10);

		JLabel lblshenfenzheng = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		lblshenfenzheng.setBounds(316, 275, 54, 15);
		add(lblshenfenzheng);

		txtshenfenzheng = new JTextField();
		txtshenfenzheng.setBounds(384, 272, 128, 21);
		add(txtshenfenzheng);
		txtshenfenzheng.setColumns(10);

		JLabel lblxuezhi = new JLabel("\u5B66\u5236");
		lblxuezhi.setBounds(30, 275, 54, 15);
		add(lblxuezhi);

		Xuezhi = new Choice();
		Xuezhi.add("三年");
		Xuezhi.add("四年");
		Xuezhi.add("两年");
		Xuezhi.setBounds(90, 272, 78, 21);
		add(Xuezhi);

		txtxueyuan = new JTextField();
		txtxueyuan.setBounds(90, 136, 146, 21);
		add(txtxueyuan);
		txtxueyuan.setColumns(10);

		JLabel lblyingyudengji = new JLabel("\u82F1\u8BED\u7B49\u7EA7");
		lblyingyudengji.setBounds(316, 314, 54, 15);
		add(lblyingyudengji);

		txtyingyudengji = new JTextField();
		txtyingyudengji.setBounds(384, 311, 128, 21);
		add(txtyingyudengji);
		txtyingyudengji.setColumns(10);

		JLabel lbllianxidianhua = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		lbllianxidianhua.setBounds(30, 314, 54, 15);
		add(lbllianxidianhua);

		txtlianxidianhua = new JTextField();
		txtlianxidianhua.setBounds(90, 311, 146, 21);
		add(txtlianxidianhua);
		txtlianxidianhua.setColumns(10);

		JLabel lbljiangcheng = new JLabel("\u5956\u60E9\u8BB0\u5F55");
		lbljiangcheng.setBounds(30, 394, 54, 15);
		add(lbljiangcheng);

		txtjiangcheng = new JTextField();
		txtjiangcheng.setBounds(90, 360, 422, 78);
		add(txtjiangcheng);
		txtjiangcheng.setColumns(10);

		JRadioButton radman = new JRadioButton("\u7537");
		radman.setSelected(true);
		radman.setBounds(87, 95, 61, 23);
		add(radman);

		JRadioButton radwoman = new JRadioButton("\u5973");
		radwoman.setBounds(150, 95, 86, 23);
		add(radwoman);

		ButtonGroup group = new ButtonGroup();
		group.add(radman);
		group.add(radwoman);

		JLabel lbltop = new JLabel("\u5B66\u751F\u4E2A\u4EBA\u4FE1\u606F");
		lbltop.setFont(new Font("宋体", Font.PLAIN, 20));
		lbltop.setBounds(205, 20, 128, 28);
		add(lbltop);

		JButton btnxiugai = new JButton("\u4FEE\u6539");
		btnxiugai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Test.userBean.getShenhe() != 0) {
					String sex = "";
					if (radman.isSelected()) {
						sex = radman.getText();
					} else {
						sex = radwoman.getText();
					}
					String xuezhi = Xuezhi.getSelectedItem();
					String kaoshenghao = txtkaoshenghao.getText();
					String xueyuan = txtxueyuan.getText();
					System.out.println(xueyuan);
					String minzu = txtminzu.getText();
					String name = txtname.getText();
					String xuehao = txtxuehao.getText();
					String nianji = txtnianji.getText();
					String zhengzhimianmao = txtzhengzhimianmao.getText();
					String xueli = txtxueli.getText();
					String zhuanye = txtzhuanye.getText();
					String shenfenzheng = txtshenfenzheng.getText();
					String yingyudengji = txtyingyudengji.getText();
					String lianxidianhua = txtlianxidianhua.getText();
					String jiangcheng = txtjiangcheng.getText();
					BenkeShengyuanBean bean = new BenkeShengyuanBean();
					bean.setKaoshenghao(kaoshenghao);
					bean.setMinzu(minzu);
					bean.setMinzu(xuezhi);
					bean.setSex(sex);
					bean.setXueyuan(xueyuan);
					bean.setName(name);
					bean.setXuehao(xuehao);
					bean.setNianji(nianji);
					bean.setZhengzhimianmiao(zhengzhimianmao);
					bean.setXueli(xueli);
					bean.setZhuanye(zhuanye);
					bean.setShenfenzheng(shenfenzheng);
					bean.setWaiyudengji(yingyudengji);
					bean.setLianxidianhua(lianxidianhua);
					bean.setChengfa(jiangcheng);
					bean.setId(Test.userBean.getStuid());
					BenkeShengyuanAction action = new BenkeShengyuanAction();
					int n = action.updateBksy(bean);
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "修改成功");
						XianshiXueshengPanel show = new XianshiXueshengPanel();
						// 生成新的面板，面板大小和原来的一样
						show.setSize(MainFrame.rightPanel.getSize());
						// 移除原来的信息
						MainFrame.rightPanel.removeAll();
						MainFrame.rightPanel.add(show);
						MainFrame.rightPanel.repaint();
					}
				}
			}
		});
		btnxiugai.setBounds(88, 459, 93, 23);
		add(btnxiugai);

		JButton btntijiao = new JButton("\u63D0\u4EA4");
		btntijiao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBean ubean = new UserBean();
				ubean.setShenhe(Test.userBean.getShenhe() + 1);
				ubean.setId(Test.userBean.getId());
				UserAction useaction = new UserAction();
				int row = useaction.updateUserShenheCishu(ubean);
				if (row > 0) {
					JOptionPane.showMessageDialog(null, "提交成功");
					radman.setEnabled(false);
					radwoman.setEnabled(false);
					txtkaoshenghao.setEditable(false);
					txtminzu.setEditable(false);
					txtname.setEditable(false);
					txtxuehao.setEditable(false);
					txtnianji.setEditable(false);
					txtzhengzhimianmao.setEditable(false);
					txtxueli.setEditable(false);
					txtzhuanye.setEditable(false);
					txtshenfenzheng.setEditable(false);
					txtyingyudengji.setEditable(false);
					txtlianxidianhua.setEditable(false);
					txtjiangcheng.setEditable(false);
					txtxueyuan.setEditable(false);
					Xuezhi.disable();
										
				}

			}
		});
		btntijiao.setBounds(337, 459, 93, 23);
		add(btntijiao);

		BenkeShengyuanAction actioin = new BenkeShengyuanAction();
		int stuid = Test.userBean.getStuid();
		if (stuid != -1) {
			BenkeShengyuanBean bean = actioin.selectById(stuid);
			if (bean.getSex().equals("男")) {
				radman.setSelected(true);
			} else {
				radwoman.setSelected(true);
			}
			txtkaoshenghao.setText(bean.getKaoshenghao());
			txtxueyuan.setText(bean.getXueyuan());
			txtminzu.setText(bean.getMinzu());
			txtname.setText(bean.getName());
			txtxuehao.setText(bean.getXuehao());
			txtnianji.setText(bean.getNianji());
			txtzhengzhimianmao.setText(bean.getZhengzhimianmiao());
			txtxueli.setText(bean.getXueli());
			txtzhuanye.setText(bean.getZhuanye());
			txtshenfenzheng.setText(bean.getShenfenzheng());
			txtlianxidianhua.setText(bean.getLianxidianhua());
			txtjiangcheng.setText(bean.getChengfa());
			txtyingyudengji.setText(bean.getWaiyudengji());
		}

	}

}
