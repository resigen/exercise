package com.zhuoshi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.zhuoshi.action.ShengYuanAction;
import com.zhuoshi.bean.ShengYuanBean;
import com.zhuoshi.tool.CheckHeaderCellRenderer;
import com.zhuoshi.tool.CheckTableModle;
import com.zhuoshi.tool.ExcelOperate;

public class ShengYuanPanel extends JPanel {

	/**
	 * Create the panel.
	 */

		private JTextField txtsycode;
		private JTextField txtsyname;
		private JTable table;
		private JScrollPane scrollPane;
		private int rowsByPage=17;//每页条数
		private int pages= 0;//一共多少页
		private int currentPage= 1;//当前是第几页
		private int totalRows = 0;//一共多少条数据
		private JButton btnFirst;
		private JButton btnPrevious;
		private JButton btnNext;
		private JButton btnLast;


		private void initPage()
		{
			ShengYuanAction action =new ShengYuanAction();
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
		public ShengYuanPanel() {
			initPage();
			this.setLayout(null);

			JLabel lblsycode = new JLabel("\u751F\u6E90\u5730\u4EE3\u7801");
			lblsycode.setBounds(83, 39, 79, 15);
			add(lblsycode);

			txtsycode = new JTextField();
			txtsycode.setBounds(187, 36, 259, 21);
			add(txtsycode);
			txtsycode.setColumns(10);

			JLabel lblsyname = new JLabel("\u751F\u6E90\u5730\u540D\u79F0");
			lblsyname.setBounds(83, 81, 79, 15);
			add(lblsyname);

			txtsyname = new JTextField();
			txtsyname.setBounds(187, 78, 259, 21);
			add(txtsyname);
			txtsyname.setColumns(10);

			JButton btnAdd = new JButton("\u6DFB\u52A0");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = 0;
					if(!txtsycode.getText().equals("")&&!txtsyname.getText().equals(""))
					{
					String code = txtsycode.getText();
					String name = txtsyname.getText();
					ShengYuanBean bean = new ShengYuanBean();
					bean.setSydcode(code);
					bean.setSydname(name);
					ShengYuanAction action = new ShengYuanAction();
					n = action.addBenzhuan(bean);
				}else
				{
					JOptionPane.showMessageDialog(null,"请输入添加信息");
				}
					if (n > 0) {
						BenZhuanView show = new BenZhuanView();
						// 生成新的面板，面板大小和原来的一样
						show.setSize(MainFrame.rightPanel.getSize());
						// 移除原来的信息
						MainFrame.rightPanel.removeAll();
						MainFrame.rightPanel.add(show);
						MainFrame.rightPanel.repaint();
					}
				}
			});
			btnAdd.setBounds(160, 119, 93, 23);
			add(btnAdd);

			JButton btnAddall = new JButton("\u6279\u91CF\u6DFB\u52A0");
			btnAddall.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						JFileChooser jfc = new JFileChooser("c://");
						int n = jfc.showOpenDialog(null);
						if (n == 0) {
							File file = jfc.getSelectedFile();
							String[][] result = ExcelOperate.getData(file, 1);
							int rowLength = result.length;
							List<ShengYuanBean> shengyuans = new ArrayList<ShengYuanBean>();
							for (int i = 0; i < rowLength; i++) {
								ShengYuanBean bean = new ShengYuanBean();
								bean.setSydcode(result[i][0]);
								bean.setSydname(result[i][1]);
								shengyuans.add(bean);
							}
							System.out.println();
							ShengYuanAction action = new ShengYuanAction();
							int k = action.addBenzhuans(shengyuans);
							if (k == 0) {
								JOptionPane.showMessageDialog(null, "导入成功");
								BenZhuanView show = new BenZhuanView();
								// 生成新的面板，面板大小和原来的一样
								show.setSize(MainFrame.rightPanel.getSize());
								// 移除原来的信息
								MainFrame.rightPanel.removeAll();
								MainFrame.rightPanel.add(show);
								MainFrame.rightPanel.repaint();
							}
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
			btnAddall.setBounds(314, 119, 93, 23);
			add(btnAddall);

			JButton btnDeleteall = new JButton("\u6279\u91CF\u5220\u9664");
			btnDeleteall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<ShengYuanBean> shengyuans = new ArrayList<ShengYuanBean>();
				for (int i = 0; i < rowsByPage; i++) {
					boolean result = (Boolean) table.getValueAt(i, 0);
					int id = (Integer) table.getValueAt(i, 1);
					if (result != false) {
						ShengYuanBean bean = new ShengYuanBean();
						bean.setId(id);
						shengyuans.add(bean);
					}
				}
				ShengYuanAction action = new ShengYuanAction();
				int k = action.delectallBenzhuans(shengyuans);
				if (k == 0) {
					if (shengyuans.size() > 0) 
					{
						JOptionPane.showMessageDialog(null, "批量删除成功");
					} else {
						JOptionPane.showMessageDialog(null, "请选择");
					}
					ShengYuanPanel show = new ShengYuanPanel();
					// 生成新的面板，面板大小和原来的一样
					show.setSize(MainFrame.rightPanel.getSize());
					// 移除原来的信息
					MainFrame.rightPanel.removeAll();
					MainFrame.rightPanel.add(show);
					MainFrame.rightPanel.repaint();
				}

			}
			});
			btnDeleteall.setBounds(460, 119, 93, 23);
			add(btnDeleteall);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(28, 167, 525, 300);
			add(scrollPane);
			
			JButton btnSelect = new JButton("\u67E5\u8BE2");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ShengYuanBean bean = new ShengYuanBean();				
						bean.setSydname(txtsyname.getText());					
						bean.setSydcode(txtsycode.getText());				
						ShengYuanAction action = new ShengYuanAction();
						List<ShengYuanBean> shengyuans = action.selectAll(bean, 0, 0);
						initTable(shengyuans);
					}
			});
			btnSelect.setBounds(28, 119, 93, 23);
			add(btnSelect);
			
			btnFirst = new JButton("\u7B2C\u4E00\u9875");
			btnFirst.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentPage=1;
					ShengYuanAction action = new ShengYuanAction();
					List<ShengYuanBean> shengyuans= action.selectAll(null,currentPage-1,rowsByPage);
					initTable(shengyuans); 
				}
			});
			btnFirst.setBounds(28,477, 79, 23);
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
						ShengYuanAction action = new ShengYuanAction();
						List<ShengYuanBean> shengyuans= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
						initTable(shengyuans); 
					}
					
				}
			});
			btnPrevious.setBounds(192,477, 77, 23);
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
						ShengYuanAction action = new ShengYuanAction();
						List<ShengYuanBean> shengyuans= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
						initTable(shengyuans); 
					}
					
				}
			});
			btnNext.setBounds(333,477, 77, 23);
			add(btnNext);
			
			btnLast = new JButton("\u6700\u540E\u4E00\u9875");
			btnLast.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentPage = pages;
					ShengYuanAction action = new ShengYuanAction();
					List<ShengYuanBean> shengyuans = action.selectAll(null, (currentPage - 1) * rowsByPage, rowsByPage);
					initTable(shengyuans);
				}
			});
			btnLast.setBounds(467,477, 86, 23);
			add(btnLast);
			
			ShengYuanAction action = new ShengYuanAction();
			List<ShengYuanBean> shengyuans= action.selectAll(null, 0, 0);
			initTable(shengyuans);
			
		}
		private void initTable(List<ShengYuanBean> shengyuans) {
//			DefaultTableModel dtm = new DefaultTableModel();
//			// 添加表头数据
//	        dtm.add("全选/全不选");
//			dtm.add("编号");
//			dtm.add("专业代码");
//			dtm.add("专业名称");
//			dtm.add("");
//			dtm.add("");
			
			Vector date = new Vector();
			// 添加表格数据
			for (ShengYuanBean shnegyuan : shengyuans) {
				Vector row = new Vector();
				row.add(false);
				row.add(shnegyuan.getId());
				row.add(shnegyuan.getSydcode());
				row.add(shnegyuan.getSydname());
				row.add("修改");
				row.add("删除");			
				date.add(row);
			}
			Vector headNames = new Vector();
			headNames.add("全选");
			headNames.add("编号");
			headNames.add("专业代码");
			headNames.add("专业名称");
			headNames.add("");
			headNames.add("");
			CheckTableModle c=new CheckTableModle(date,headNames);
			table = new JTable(c);
			table.getTableHeader().setDefaultRenderer(new CheckHeaderCellRenderer(table));
			//table.repaint();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					int id = Integer.parseInt(table.getValueAt(row,1).toString());

					if (column == 4) {
						// 显示修改对话框 (模式对话框)
						UpdateShengYuanDialog sydialog = new UpdateShengYuanDialog(id);
						Test.updateShengYuanDialog = sydialog;
						sydialog.setVisible(true);

					}
					if (column == 5) {

						int n = JOptionPane.showConfirmDialog(null, "是否删除?", "删除对话框", JOptionPane.YES_NO_OPTION);
						if (n == 0) {
							ShengYuanAction action = new ShengYuanAction();
							action.deleteBenzhuan(id);
						}
					}
					ShengYuanAction action = new ShengYuanAction();
					List<ShengYuanBean> shengyuans = action.selectAll(null, 0, 0);
					initTable(shengyuans);
				}
			});
			scrollPane.setViewportView(table);
		}	


}
