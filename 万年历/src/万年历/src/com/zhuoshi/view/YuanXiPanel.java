package com.zhuoshi.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zhuoshi.action.BenZhuanAction;
import com.zhuoshi.action.BenkeShengyuanAction;
import com.zhuoshi.action.StudentAction;
import com.zhuoshi.action.YuanXiAction;
import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.bean.YuanXiBean;
import com.zhuoshi.tool.CheckHeaderCellRenderer;
import com.zhuoshi.tool.CheckTableModle;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class YuanXiPanel extends JPanel {
	private JTextField txtzhuanye;
	private JTextField txtyuanxi;
	private JTable table;
	private int rowsByPage=15;//每页条数
	private int pages= 0;//一共多少页
	private int currentPage= 1;//当前是第几页
	private int totalRows = 0;//一共多少条数据
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	private void initPage()
	{
		YuanXiAction action =new YuanXiAction();
		//计算一共有多少条数据
		int totalRows = action.count();
		
		//计算一共有多少页
		if(totalRows%rowsByPage==0)
		{
			pages=totalRows/rowsByPage;
		}else{
			pages=totalRows/rowsByPage+1;
		}
	}
	public YuanXiPanel() {
		setLayout(null);
		initPage();
		
		JLabel lblzhuanye = new JLabel("\u4E13\u4E1A");
		lblzhuanye.setBounds(68, 59, 54, 15);
		add(lblzhuanye);
		
		txtzhuanye = new JTextField();
		txtzhuanye.setBounds(115, 56, 132, 21);
		add(txtzhuanye);
		txtzhuanye.setColumns(10);
		
		JLabel lblyuanxi = new JLabel("\u9662\u7CFB");
		lblyuanxi.setBounds(285, 59, 54, 15);
		add(lblyuanxi);
		
		txtyuanxi = new JTextField();
		txtyuanxi.setBounds(359, 56, 143, 21);
		add(txtyuanxi);
		txtyuanxi.setColumns(10);
		
		JButton butadd = new JButton("\u6DFB\u52A0");
		butadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		butadd.setBounds(140, 113, 93, 23);
		add(butadd);
		
		JButton btnselect = new JButton("\u67E5\u8BE2");
		btnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YuanXiBean bean = new YuanXiBean();				
				bean.setProfessorname(txtzhuanye.getText());					
				bean.setCollegename(txtyuanxi.getText());				
				YuanXiAction action = new YuanXiAction();
				List<YuanXiBean> yuanxis = action.selectAll(bean);
				initTable(yuanxis);
			}
		});
		btnselect.setBounds(344, 113, 93, 23);
		add(btnselect);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 165, 434, 260);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnFirst = new JButton("\u7B2C\u4E00\u9875");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPage=1;
				YuanXiAction action = new YuanXiAction();
				List<YuanXiBean> yuanxis= action.selectAll(currentPage-1,rowsByPage);
				initTable(yuanxis); 
				
			}
		});
		btnFirst.setBounds(43, 451, 93, 23);
		add(btnFirst);
		
		btnPrevious = new JButton("\u4E0A\u4E00\u9875");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentPage==1)
				{
					JOptionPane.showMessageDialog(null,"已经到第一页");
				}
				if (currentPage>1) {
					currentPage--;
					YuanXiAction action = new YuanXiAction();
					List<YuanXiBean> yuanxis= action.selectAll((currentPage - 1) * rowsByPage,rowsByPage);
					initTable(yuanxis); 
					//initTable(null, (currentPage - 1) * rowsByPage, rowsByPage);
				}
			}
		});
		btnPrevious.setBounds(185, 451, 93, 23);
		add(btnPrevious);
		
		btnNext = new JButton("\u4E0B\u4E00\u9875");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentPage==pages)
				{
					JOptionPane.showMessageDialog(null,"已经到最后一页");
				}
				if (currentPage < pages) {
					currentPage++;
					YuanXiAction action = new YuanXiAction();
					List<YuanXiBean> yuanxis= action.selectAll((currentPage - 1) * rowsByPage,rowsByPage);
					initTable(yuanxis);  
					//initTable(null, (currentPage - 1) * rowsByPage, rowsByPage);
				}
			}
		});
		btnNext.setBounds(320, 451, 93, 23);
		add(btnNext);
		
		btnLast = new JButton("\u6700\u540E\u4E00\u9875");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPage=pages;
				YuanXiAction action = new YuanXiAction();
				List<YuanXiBean> yuanxis= action.selectAll((currentPage - 1) * rowsByPage,rowsByPage);
				initTable(yuanxis);  
			}
		});
		btnLast.setBounds(453, 451, 108, 23);
		add(btnLast);
		
		YuanXiAction action = new YuanXiAction();
		List<YuanXiBean> yuanxi = action.selectzyxy();
		initTable(yuanxi);

	}

	
	
	private void initTable(List<YuanXiBean> yuanxis) {
		// 添加表格数据
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("编号");
		dtm.addColumn("学院");
		dtm.addColumn("专业");
		dtm.addColumn("");
		dtm.addColumn("");
		for (YuanXiBean yuanxi : yuanxis) {
			Vector row = new Vector();
			row.add(yuanxi.getPid());
			row.add(yuanxi.getCollegename());
			row.add(yuanxi.getProfessorname());
			row.add("修改");
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

				if (column == 3) {
					// 显示修改对话框 (模式对话框)
//					BenkeShengyuanDialog sydialog = new BenkeShengyuanDialog(id);
//					Test.BenkeShengyuanDialog = sydialog;
//					sydialog.setVisible(true);

				}
				if (column == 4) {

					int n = JOptionPane.showConfirmDialog(null, "是否删除?", "删除对话框", JOptionPane.YES_NO_OPTION);
					if (n == 0) {
						YuanXiAction action = new YuanXiAction();
						action.deleteyuanxi(id);
					}
				}
				YuanXiAction action = new YuanXiAction();
				List<YuanXiBean> yuanxi = action.selectzyxy();
				initTable(yuanxi);
			}
		});
		scrollPane.setViewportView(table);
	}
}
