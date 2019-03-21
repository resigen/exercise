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

	private int rowsByPage=5;//ÿҳ����
	private int pages= 0;//һ������ҳ
	private int currentPage= 1;//��ǰ�ǵڼ�ҳ
	private int totalRows = 0;//һ������������
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	
	private void initPage()
	{
		StudentAction action =new StudentAction();
		//����һ���ж���������
		int totalRows = action.count();
		
		//����һ���ж���ҳ
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
					JOptionPane.showMessageDialog(null,"�Ѿ�����һҳ");
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
					JOptionPane.showMessageDialog(null,"�Ѿ������һҳ");
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
		//һ��ʼˢ�±��
		StudentAction action = new StudentAction();
		List<StudentBean> students= action.selectAll(null, 0, 0);
		initTable(students);
	}

	// list����
	private void initTable(List<StudentBean> students) {
		DefaultTableModel dtm = new DefaultTableModel();
		// ��ӱ�ͷ����		
		dtm.addColumn("���");
		dtm.addColumn("����");
		dtm.addColumn("�Ա�");
		dtm.addColumn("����");
		dtm.addColumn("��ַ");
		dtm.addColumn("");
		dtm.addColumn("");
		
		dtm.addColumn("ȫѡ");
		// ��ӱ������
		for (StudentBean student : students) {
			Vector row = new Vector();
			row.add(student.getId());
			row.add(student.getName());
			row.add(student.getSex());
			row.add(student.getAge());
			row.add(student.getAddress());
			row.add("�޸�");
			row.add("ɾ��");
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
					// ��ʾ�޸ĶԻ��� (ģʽ�Ի���)
					UpdateStudentDialog dialog = new UpdateStudentDialog(id);
					Test.updateStudentDialog = dialog;
					dialog.setVisible(true);
					
					// ˢ�±��
					// JOptionPane.showMessageDialog(null,"ˢ��");
					//initTable(null, 0, 0);

				}
				if (column == 6) {

					int n = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��?", "ɾ���Ի���", JOptionPane.YES_NO_OPTION);
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
//		// �������ģ��
//		DefaultTableModel dtm = new DefaultTableModel();
//		dtm.addColumn("���");
//		dtm.addColumn("����");
//		dtm.addColumn("�Ա�");
//		dtm.addColumn("����");
//		dtm.addColumn("��ַ");
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
//			row.add("�޸�");
//			row.add("ɾ��");
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
//					// ��ʾ�޸ĶԻ��� (ģʽ�Ի���)
//					UpdateStudentDialog dialog = new UpdateStudentDialog(id);
//					Test.updateStudentDialog = dialog;
//					dialog.setVisible(true);
//					// ˢ�±��
//					// JOptionPane.showMessageDialog(null,"ˢ��");
//					initTable(null,0,0);
//
//				}
//				if (column == 6) {
//
//					int n = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��?", "ɾ���Ի���", JOptionPane.YES_NO_OPTION);
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
