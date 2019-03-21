package com.zhuoshi.view;

import javax.swing.JPanel;

import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.zhuoshi.action.StudentAction;
import com.zhuoshi.bean.StudentBean;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowStudentPanel extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtName;
	private JTextField txtAddress;

	private int rowsByPage=5;//每页条数
	private int pages= 0;//一共多少页
	private int currentPage= 1;//当前是第几页
	private int totalRows = 0;//一共多少条数据
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	
	private void initPage()
	{
		StudentAction action =new StudentAction();
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
	/**
	 * Create the panel.
	 */
	public ShowStudentPanel() {
		initPage();
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 359, 164);
		add(scrollPane);
		
		JLabel lblName = new JLabel("\u59D3\u540D");
		lblName.setEnabled(false);
		lblName.setBounds(10, 22, 54, 15);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(47, 19, 103, 21);
		add(txtName);
		txtName.setColumns(10);
		
		JLabel lblAddress = new JLabel("\u5730\u5740");
		lblAddress.setEnabled(false);
		lblAddress.setBounds(186, 25, 54, 15);
		add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(223, 19, 146, 21);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentBean bean =new StudentBean();
				bean.setName(txtName.getText());
				bean.setAddress(txtAddress.getText());
				StudentAction action = new StudentAction();
				List<StudentBean> students= action.selectAll(bean, 0, 0);
				initTable(students);
				
			}
		});
		button.setBounds(121, 58, 93, 23);
		add(button);
		
		btnFirst = new JButton("\u7B2C\u4E00\u9875");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPage=1;
				StudentAction action = new StudentAction();
				List<StudentBean> students= action.selectAll(null,currentPage-1,rowsByPage);
				initTable(students); 
				//initTable(null,currentPage-1,rowsByPage);
			}
		});
		btnFirst.setBounds(20, 267, 79, 23);
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
					StudentAction action = new StudentAction();
					List<StudentBean> students= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
					initTable(students); 
					//initTable(null, (currentPage - 1) * rowsByPage, rowsByPage);
				}
				
			}
		});
		btnPrevious.setBounds(109, 267, 77, 23);
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
					StudentAction action = new StudentAction();
					List<StudentBean> students= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
					initTable(students); 
					//initTable(null, (currentPage - 1) * rowsByPage, rowsByPage);
				}
				
			}
		});
		btnNext.setBounds(196, 267, 77, 23);
		add(btnNext);
		
		btnLast = new JButton("\u6700\u540E\u4E00\u9875");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPage=pages;
				StudentAction action = new StudentAction();
				List<StudentBean> students= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
				initTable(students); 
				//initTable(null, (currentPage - 1) * rowsByPage, rowsByPage);
			}
		});
		btnLast.setBounds(283, 267, 86, 23);
		add(btnLast);
		//一开始刷新表格
		StudentAction action = new StudentAction();
		List<StudentBean> students= action.selectAll(null, 0, 0);
		initTable(students);
	}

	// list数据
	private void initTable(List<StudentBean> students) {
		DefaultTableModel dtm = new DefaultTableModel();
		// 添加表头数据		
		dtm.addColumn("编号");
		dtm.addColumn("姓名");
		dtm.addColumn("性别");
		dtm.addColumn("年龄");
		dtm.addColumn("地址");
		dtm.addColumn("");
		dtm.addColumn("");
		
		dtm.addColumn("全选");
		// 添加表格数据
		for (StudentBean student : students) {
			Vector row = new Vector();
			row.add(student.getId());
			row.add(student.getName());
			row.add(student.getSex());
			row.add(student.getAge());
			row.add(student.getAddress());
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

				if (column == 5) {
					// 显示修改对话框 (模式对话框)
					UpdateStudentDialog dialog = new UpdateStudentDialog(id);
					Test.updateStudentDialog = dialog;
					dialog.setVisible(true);
					
					// 刷新表格
					// JOptionPane.showMessageDialog(null,"刷新");
					//initTable(null, 0, 0);

				}
				if (column == 6) {

					int n = JOptionPane.showConfirmDialog(null, "是否删除?", "删除对话框", JOptionPane.YES_NO_OPTION);
					if (n == 0) {
						StudentAction action = new StudentAction();
						action.deleteStudent(id);
						//initTable(null, 0, 0);
					}
				}
				StudentAction action = new StudentAction();
				List<StudentBean> students= action.selectAll(null,0,0);
				initTable(students);
			}
		});
		scrollPane.setViewportView(table);
	}
//  
//	private void initTable(StudentBean bean,int begin,int rowsByPage) {
//		// 构建表格模型
//		DefaultTableModel dtm = new DefaultTableModel();
//		dtm.addColumn("编号");
//		dtm.addColumn("姓名");
//		dtm.addColumn("性别");
//		dtm.addColumn("年龄");
//		dtm.addColumn("地址");
//		dtm.addColumn("");
//		dtm.addColumn("");
//		StudentAction action = new StudentAction();
//		List<StudentBean> students = null;
//		if (bean == null&&begin==0&&rowsByPage==0) 
//		{
//			
//			students = action.selectAll();
//			
//		} 
//		if (bean != null&&begin==0&&rowsByPage==0)
//		{
//		
//			students=action.selectAll(bean);
//
//		}
//		if (bean == null&&rowsByPage!=0)
//		{
//			
//			students=action.selectAll(begin,rowsByPage);
//
//		}
//		for (StudentBean student : students) {
//			Vector row = new Vector();
//			row.add(student.getId());
//			row.add(student.getName());
//			row.add(student.getSex());
//			row.add(student.getAge());
//			row.add(student.getAddress());
//			row.add("修改");
//			row.add("删除");
//			dtm.addRow(row);
//		}
//		table = new JTable(dtm);
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				int row = table.getSelectedRow();
//				int column = table.getSelectedColumn();
//				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
//
//				if (column == 5) {
//					// 显示修改对话框 (模式对话框)
//					UpdateStudentDialog dialog = new UpdateStudentDialog(id);
//					Test.updateStudentDialog = dialog;
//					dialog.setVisible(true);
//					// 刷新表格
//					// JOptionPane.showMessageDialog(null,"刷新");
//					initTable(null,0,0);
//
//				}
//				if (column == 6) {
//
//					int n = JOptionPane.showConfirmDialog(null, "是否删除?", "删除对话框", JOptionPane.YES_NO_OPTION);
//					if (n == 0) {
//						StudentAction action = new StudentAction();
//						action.deleteStudent(id);
//						initTable(null,0,0);
//					}
//				}
//			}
//		});
//		scrollPane.setViewportView(table);
//	}

}
