package com.zhuoshi.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.zhuoshi.action.StudentAction;
import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.tool.ExcelOperate;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtAddress;

	/**
	 * Create the panel.
	 */
	public AddStudentPanel() {
		setLayout(null);
		
		JLabel lblName = new JLabel("\u59D3\u540D");
		lblName.setBounds(79, 54, 36, 15);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(141, 51, 143, 21);
		add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSex = new JLabel("\u6027\u522B");
		lblSex.setBounds(79, 99, 54, 15);
		add(lblSex);
		
		JRadioButton radMale = new JRadioButton("\u7537");
		radMale.setSelected(true);
		radMale.setBounds(141, 95, 61, 23);
		add(radMale);
		
		JRadioButton radFemale = new JRadioButton("\u5973");
		radFemale.setBounds(221, 95, 61, 23);
		add(radFemale);
		
		JLabel lblAge = new JLabel("\u5E74\u9F84");
		lblAge.setBounds(79, 147, 36, 15);
		add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setBounds(141, 144, 66, 21);
		add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblAddress = new JLabel("\u5730\u5740");
		lblAddress.setBounds(79, 194, 36, 15);
		add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(141, 191, 210, 21);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = txtName.getText();
				String sex ="";
				if(radMale.isSelected())
				{
					sex =radMale.getText();
				}else
				{
					sex =radFemale.getText();
				}
				int age = Integer.parseInt(txtAge.getText());
				String address =txtAddress.getText();
				StudentBean bean = new StudentBean();
				bean.setName(name);
				bean.setSex(sex);
				bean.setAge(age);
				bean.setAddress(address);
				StudentAction action = new StudentAction();
				int n = action.addStudent(bean);
				if(n>0)
				{
					//JOptionPane.showMessageDialog(null,"添加成功");
					ShowStudentPanel showstudentpanel = new ShowStudentPanel();
					//生成新的面板，面板大小和原来的一样
					showstudentpanel.setSize(MainFrame.rightPanel.getSize());
					//移除原来的信息
					MainFrame.rightPanel.removeAll();
					MainFrame.rightPanel.add(showstudentpanel);
					MainFrame.rightPanel.repaint();
				}
			}
		});
		btnAdd.setBounds(93, 243, 93, 23);
		add(btnAdd);
		
		JButton butAll = new JButton("\u6279\u91CF\u5BFC\u5165");
		butAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser jfc = new JFileChooser("c://");
					int n = jfc.showOpenDialog(null);
					if (n == 0) {
						File file = jfc.getSelectedFile();
						String[][] result = ExcelOperate.getData(file, 1);
						int rowLength = result.length;
						List<StudentBean> students = new ArrayList<StudentBean>();
						for (int i = 0; i < rowLength; i++) {
							StudentBean bean = new StudentBean();
							bean.setName(result[i][0]);
							bean.setSex(result[i][1]);
							bean.setAge(20);
							bean.setAddress(result[i][2]);
                            students.add(bean);
						}
						System.out.println();
						StudentAction action = new StudentAction();
						int k = action.addStudents(students);
						if(k==0)
						{
							JOptionPane.showMessageDialog(null,"导入成功");
						}
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		butAll.setBounds(247, 243, 93, 23);
		add(butAll);

	}
}
