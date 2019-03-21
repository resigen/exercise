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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(233, 44, 134, 24);
		add(lblNewLabel);	
		
		RiZhiAction a = new RiZhiAction();
		List<RiZiBean> rs= a.selectAll();
		initTable(rs);

	}
	
	private void initTable(List<RiZiBean> rizhis) {
		DefaultTableModel dtm = new DefaultTableModel();
		// ��ӱ�ͷ����		
		dtm.addColumn("���");
		dtm.addColumn("�û���");
		dtm.addColumn("��¼ʱ��");
		dtm.addColumn("�˳�ʱ��");
		// ��ӱ������
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
