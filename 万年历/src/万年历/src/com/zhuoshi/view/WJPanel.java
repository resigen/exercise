package com.zhuoshi.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zhuoshi.action.RiZhiAction;
import com.zhuoshi.action.StudentAction;
import com.zhuoshi.action.WJAction;
import com.zhuoshi.bean.RiZiBean;
import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.bean.WJBean;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WJPanel extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;

	public WJPanel() {
		this.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 107, 478, 282);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("\u95EE\u5377\u8C03\u67E5");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(233, 44, 134, 24);
		add(lblNewLabel);

		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddwentiDialog ad = new AddwentiDialog();
				Test.wtaddDialog = ad;
				ad.setVisible(true);
				
				WJAction a = new WJAction();
				List<WJBean> ws = a.selectAll();
				initTable(ws);

			}
		});
		button.setBounds(408, 62, 93, 23);
		add(button);

		WJAction a = new WJAction();
		List<WJBean> ws = a.selectAll();
		initTable(ws);

	}

	private void initTable(List<WJBean> wenjuans) {
		DefaultTableModel dtm = new DefaultTableModel();
		// 添加表头数据
		dtm.addColumn("编号");
		dtm.addColumn("问题");
		dtm.addColumn(" ");
		dtm.addColumn(" ");
		dtm.addColumn(" ");
		// 添加表格数据
		for (WJBean wenjuan : wenjuans) {
			Vector row = new Vector();
			row.add(wenjuan.getId());
			row.add(wenjuan.getWenti());
			row.add("详细");
			row.add(wenjuan.getFabu());
			row.add("删除");
			dtm.addRow(row);
		}
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());

				if (column == 2) {
					// // 显示修改对话框 (模式对话框)
					WtXiangxiDialog dialog = new WtXiangxiDialog(id);
					Test.wtXiangxiDialog = dialog;
					dialog.setVisible(true);

				}
				if (column == 4) {

					int n = JOptionPane.showConfirmDialog(null, "是否删除?", "删除对话框", JOptionPane.YES_NO_OPTION);
					if (n == 0) {
						WJAction action = new WJAction();
						action.deletewenti(id);
					}
				}
				if (column == 3) {
					WJAction wja = new WJAction();
					WJBean bean = wja.selectById(id);
					if (bean.getFabu().equals("发布")) {
						int k = wja.updatefabu(id);
						if (k > 0) {
							JOptionPane.showMessageDialog(null, "发布成功");
						}
					} else {
						JOptionPane.showMessageDialog(null, "已发布");
					}
					WJAction a = new WJAction();
					List<WJBean> ws = a.selectAll();
					initTable(ws);

				}
				WJAction a = new WJAction();
				List<WJBean> ws = a.selectAll();
				initTable(ws);

			}

		});
		scrollPane.setViewportView(table);

	}

}
