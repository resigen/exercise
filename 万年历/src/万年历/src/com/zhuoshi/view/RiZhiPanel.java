package com.zhuoshi.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zhuoshi.action.RiZhiAction;
import com.zhuoshi.action.StudentAction;
import com.zhuoshi.bean.RiZiBean;
import com.zhuoshi.bean.ShengYuanBean;
import com.zhuoshi.bean.StudentBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class RiZhiPanel extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;

	public RiZhiPanel() {
		this.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 107, 478, 282);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("\u767B\u5F55\u65E5\u5FD7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(233, 44, 134, 24);
		add(lblNewLabel);	
		
		RiZhiAction a = new RiZhiAction();
		List<RiZiBean> rs= a.selectAll();
		initTable(rs);

	}
	
	private void initTable(List<RiZiBean> rizhis) {
		DefaultTableModel dtm = new DefaultTableModel();
		// 添加表头数据		
		dtm.addColumn("编号");
		dtm.addColumn("用户名");
		dtm.addColumn("登录时间");
		dtm.addColumn("退出时间");
		// 添加表格数据
		for (RiZiBean rizhi : rizhis) {
			Vector row = new Vector();
			row.add(rizhi.getId());
			row.add(rizhi.getUsername());
			row.add(rizhi.getCometime());
			row.add(rizhi.getAwaytime());
			dtm.addRow(row);
		}
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
	}		

}
