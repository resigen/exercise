package com.zhuoshi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zhuoshi.action.UserAction;
import com.zhuoshi.bean.UserBean;

public class UserManagerPanel extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtName;

	private int rowsByPage=15;//ÿҳ����
	private int pages= 0;//һ������ҳ
	private int currentPage= 1;//��ǰ�ǵڼ�ҳ
	private int totalRows = 0;//һ������������
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	
	private void initPage()
	{
		UserAction action =new UserAction();
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
	public UserManagerPanel() {		

		initPage();
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 91, 487, 277);
		add(scrollPane);
		
		JLabel lblName = new JLabel("\u7528\u6237\u540D");
		lblName.setEnabled(false);
		lblName.setBounds(93, 42, 54, 15);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(182, 39, 103, 21);
		add(txtName);
		txtName.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserBean bean =new UserBean();
				bean.setUsername(txtName.getText());
				UserAction action = new UserAction();
				List<UserBean> us= action.selectAll(bean);
				initTable(us);
				
			}
		});
		button.setBounds(338, 38, 93, 23);
		add(button);
		
		btnFirst = new JButton("\u7B2C\u4E00\u9875");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPage=1;
				UserAction action = new UserAction();
				List<UserBean> users= action.selectAll(currentPage-1,rowsByPage);
				initTable(users); 
			}
		});
		btnFirst.setBounds(57, 402, 79, 23);
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
					UserAction action = new UserAction();
					List<UserBean> users= action.selectAll((currentPage - 1) * rowsByPage,rowsByPage);
					initTable(users); 
					//initTable(null, (currentPage - 1) * rowsByPage, rowsByPage);
				}
				
			}
		});
		btnPrevious.setBounds(183, 402, 77, 23);
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
					UserAction action = new UserAction();
					List<UserBean> users= action.selectAll((currentPage - 1) * rowsByPage,rowsByPage);
					initTable(users); 
					//initTable(null, (currentPage - 1) * rowsByPage, rowsByPage);
				}
				
			}
		});
		btnNext.setBounds(330, 402, 77, 23);
		add(btnNext);
		
		btnLast = new JButton("\u6700\u540E\u4E00\u9875");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPage=pages;
				UserAction action = new UserAction();
				List<UserBean> users= action.selectAll((currentPage - 1) * rowsByPage,rowsByPage);
				initTable(users); 
				//initTable(null, (currentPage - 1) * rowsByPage, rowsByPage);
			}
		});
		btnLast.setBounds(471, 402, 86, 23);
		add(btnLast);
		//һ��ʼˢ�±��
		UserAction action = new UserAction();
		List<UserBean> ues= action.selectAll();
		initTable(ues);	

	}

	private void initTable(List<UserBean> users) {
		DefaultTableModel dtm = new DefaultTableModel();
		// ��ӱ�ͷ����
		dtm.addColumn("���");
		dtm.addColumn("�û���");
		dtm.addColumn("����");
		dtm.addColumn("");
		dtm.addColumn("");
		// ��ӱ������
		for (UserBean user : users) {
			Vector row = new Vector();
			row.add(user.getId());
			row.add(user.getUsername());
			row.add(user.getPassword());
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

				if (column == 3) {
					// ��ʾ�޸ĶԻ��� (ģʽ�Ի���)
					updateuserDialog d = new updateuserDialog(id);
					Test.updateUserDialog = d;
					d.setVisible(true);


				}
				if (column == 4) {

					int n = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��?", "ɾ���Ի���", JOptionPane.YES_NO_OPTION);
					if (n == 0) {
						UserAction action = new UserAction();
						action.deleteuser(id);
					}
				}
				UserAction action = new UserAction();
				List<UserBean> ues= action.selectAll();
				initTable(ues);	
			}
		});
		scrollPane.setViewportView(table);
	}
}
