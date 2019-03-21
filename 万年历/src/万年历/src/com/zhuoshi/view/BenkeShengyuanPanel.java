package com.zhuoshi.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.zhuoshi.action.BenZhuanAction;
import com.zhuoshi.action.BenkeShengyuanAction;
import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.tool.CheckHeaderCellRenderer;
import com.zhuoshi.tool.CheckTableModle;
import com.zhuoshi.tool.ExcelOperate;

import java.awt.Choice;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BenkeShengyuanPanel extends JPanel {
	private JTextField txtXinXi;
	private int rowsByPage=19;//每页条数
	private int pages= 0;//一共多少页
	private int currentPage= 1;//当前是第几页
	private int totalRows = 0;//一共多少条数据
	private JTable table;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JScrollPane scrollPane;
	private Choice cobXinXi;
	/**
	 * Create the panel.
	 * 
	 */
	
	private void initPage()
	{
		BenZhuanAction action =new BenZhuanAction();
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
	
	public BenkeShengyuanPanel() {
		setLayout(null);
		initPage();
		
		JLabel lblxinxi = new JLabel("\u8BF7\u8F93\u5165\u4FE1\u606F");
		lblxinxi.setBounds(66, 52, 71, 15);
		add(lblxinxi);
				
		cobXinXi = new Choice();
		cobXinXi.add("学号");
		cobXinXi.add("姓名");
		cobXinXi.add("专业");
		cobXinXi.setBounds(153, 49, 151, 24);
		add(cobXinXi);
		
		txtXinXi = new JTextField();
		txtXinXi.setBounds(351, 48, 187, 23);
		add(txtXinXi);
		txtXinXi.setColumns(10);
		
		JButton btnSelect = new JButton("\u67E5\u8BE2");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = cobXinXi.getSelectedItem();
				BenkeShengyuanBean bean = new BenkeShengyuanBean();
				bean.setXinxiname(str);
				bean.setXinxi(txtXinXi.getText());
				BenkeShengyuanAction action = new BenkeShengyuanAction();
				List<BenkeShengyuanBean> benkesys = action.selectAll(bean,0,0);
				initTable(benkesys);
			}
		});
		btnSelect.setBounds(60, 95, 93, 23);
		add(btnSelect);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdd.setBounds(187, 95, 93, 23);
		add(btnAdd);
		
		JButton btnAddAll = new JButton("\u6279\u91CF\u6DFB\u52A0");
		btnAddAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser("c://");
					int n = jfc.showOpenDialog(null);
					if (n == 0) {
						File file = jfc.getSelectedFile();
						String[][] result = ExcelOperate.getData(file, 1);
						int rowLength = result.length;
						List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
						for (int i = 0; i < rowLength; i++) {
							BenkeShengyuanBean bean = new BenkeShengyuanBean();
							bean.setKaoshenghao(result[i][0]);
							bean.setName(result[i][1]);
							bean.setSex(result[i][2]);
							bean.setXuehao(result[i][3]);
							bean.setMinzu(result[i][4]);
							bean.setZhengzhimianmiao(result[i][6]);				
							bean.setXueli(result[i][8]);
							bean.setZhuanye(result[i][10]);
							bean.setPeiyang(result[i][12]);
							bean.setShengyuandi(result[i][14]);
							bean.setChusheng(result[i][16]);
							bean.setShenfenzheng(result[i][17]);
							bean.setRuxue(result[i][18]);
							bean.setXuezhi(result[i][19]);
							bean.setDingxiang(result[i][20]);
							bean.setYuyan(result[i][21]);
							bean.setXuejibiandong(result[i][23]);
							bean.setBiye(result[i][25]);
							bean.setLianxidianhua(result[i][26]);
							bean.setEmail(result[i][27]);
							bean.setHuko(result[i][28]);
							bean.setWaiyudengji(result[i][29]);
							bean.setChengfa(result[i][30]);
							bean.setXueyuan(result[i][31]);
							bean.setNianji(result[i][32]);
							benkesys.add(bean);
						}
						System.out.println();
						BenkeShengyuanAction action = new BenkeShengyuanAction();
						int k = action.addAllBenkesys(benkesys);
						if (k == 0) {
							JOptionPane.showMessageDialog(null, "导入成功");
							BenkeShengyuanPanel show = new BenkeShengyuanPanel();
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
		btnAddAll.setBounds(321, 95, 93, 23);
		add(btnAddAll);
		
		JButton btnDelectAll = new JButton("\u6279\u91CF\u5220\u9664");
		btnDelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
				for(int i=0;i<rowsByPage;i++)
				{
					boolean result =(Boolean) table.getValueAt(i,0);
					int id=(Integer)table.getValueAt(i,1);
					if(result!=false)
					{
						BenkeShengyuanBean bean = new BenkeShengyuanBean();
					    bean.setId(id); 
					    benkesys.add(bean);
					}
					
				}
				BenkeShengyuanAction action = new BenkeShengyuanAction();
				int k = action.delectallBenkesys(benkesys);
				if (k == 0) {
					if(benkesys.size()>0)
					{
					JOptionPane.showMessageDialog(null, "批量删除成功");
					}else{
						JOptionPane.showMessageDialog(null, "请选择");
					}
					BenkeShengyuanPanel show = new BenkeShengyuanPanel();
					// 生成新的面板，面板大小和原来的一样
					show.setSize(MainFrame.rightPanel.getSize());
					// 移除原来的信息
					MainFrame.rightPanel.removeAll();
					MainFrame.rightPanel.add(show);
					MainFrame.rightPanel.repaint();
				}
				
			}
		});
		btnDelectAll.setBounds(445, 95, 93, 23);
		add(btnDelectAll);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 128, 492, 325);
		add(scrollPane);
		
		btnFirst = new JButton("\u7B2C\u4E00\u9875");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage=1;
				BenkeShengyuanAction action = new BenkeShengyuanAction();
				List<BenkeShengyuanBean> benkesys= action.selectAll(null,currentPage-1,rowsByPage);
				initTable(benkesys); 
				
			}
		});
		btnFirst.setBounds(60, 463, 93, 23);
		add(btnFirst);
		
		btnPrevious = new JButton("\u4E0A\u4E00\u9875");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPage==1)
				{
					JOptionPane.showMessageDialog(null,"已经到第一页");
				}
				if (currentPage>1) {
					currentPage--;
					BenkeShengyuanAction action = new BenkeShengyuanAction();
					List<BenkeShengyuanBean> benkesys= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
					initTable(benkesys); 
				}
				
			}
		});
		btnPrevious.setBounds(187, 463, 93, 23);
		add(btnPrevious);
		
		btnNext = new JButton("\u4E0B\u4E00\u9875");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPage==pages)
				{
					JOptionPane.showMessageDialog(null,"已经到最后一页");
				}
				if (currentPage < pages) {
					currentPage++;
					BenkeShengyuanAction action = new BenkeShengyuanAction();
					List<BenkeShengyuanBean> benkesys= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
					initTable(benkesys); 
				}
				
			}
		});
		btnNext.setBounds(321, 463, 93, 23);
		add(btnNext);
		
		btnLast = new JButton("\u6700\u540E\u4E00\u9875");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage = pages;
				BenkeShengyuanAction action = new BenkeShengyuanAction();
				List<BenkeShengyuanBean> benkesys = action.selectAll(null, (currentPage - 1) * rowsByPage, rowsByPage);
				initTable(benkesys);				
			}
		});
		btnLast.setBounds(434, 463, 104, 23);
		add(btnLast);
		
		BenkeShengyuanAction action = new BenkeShengyuanAction();
		List<BenkeShengyuanBean> benkesys= action.selectAll(null, 0, 0);
		initTable(benkesys);

	}
	private void initTable(List<BenkeShengyuanBean> benkesys) {		
		Vector date = new Vector();
		// 添加表格数据
		for (BenkeShengyuanBean benkesy : benkesys) {
			Vector row = new Vector();
			row.add(false);
			row.add(benkesy.getId());
			row.add(benkesy.getName());
			row.add(benkesy.getSex());
			row.add(benkesy.getXuehao());
			row.add(benkesy.getZhuanye());
			row.add("修改");
			row.add("删除");	
			row.add("详细");	
			date.add(row);
		}
		Vector headNames = new Vector();
		headNames.add("全选");
		headNames.add("编号");
		headNames.add("姓名");
		headNames.add("性别");
		headNames.add("学号");
		headNames.add("专业");
		headNames.add("");
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
				int id = Integer.parseInt(table.getValueAt(row, 1).toString());

				if (column == 6) {
					// 显示修改对话框 (模式对话框)
					BenkeShengyuanDialog sydialog = new BenkeShengyuanDialog(id);
					Test.BenkeShengyuanDialog = sydialog;
					sydialog.setVisible(true);

				}
				if (column == 7) {

					int n = JOptionPane.showConfirmDialog(null, "是否删除?", "删除对话框", JOptionPane.YES_NO_OPTION);
					if (n == 0) {
						BenkeShengyuanAction action = new BenkeShengyuanAction();
						action.deleteBenkesy(id);
					}
				}
				if (column == 8) {

					BenkeShengyuanxiangxiDialog xidialog = new BenkeShengyuanxiangxiDialog(id);
					Test.benkeShengyuanxiangxiDialog = xidialog;
					xidialog.setVisible(true);
				}
				BenkeShengyuanAction action = new BenkeShengyuanAction();
				List<BenkeShengyuanBean> benkesy = action.selectAll(null, 0, 0);
				initTable(benkesy);
			}
		});
		scrollPane.setViewportView(table);
	}
}
