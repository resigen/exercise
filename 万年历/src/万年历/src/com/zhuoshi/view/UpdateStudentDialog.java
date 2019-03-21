package com.zhuoshi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zhuoshi.action.StudentAction;
import com.zhuoshi.bean.StudentBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudentDialog extends JDialog {
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtAddress;


	/**
	 * Create the dialog.
	 */
	public UpdateStudentDialog(int id) {
		//设置成模式对话框
		this.setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JLabel lblName = new JLabel("\u59D3\u540D");
		lblName.setBounds(79, 30, 36, 15);
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(141, 27, 143, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSex = new JLabel("\u6027\u522B");
		lblSex.setBounds(79, 76, 54, 15);
		getContentPane().add(lblSex);
		
		JRadioButton radMale = new JRadioButton("\u7537");
		radMale.setSelected(true);
		radMale.setBounds(141, 72, 61, 23);
		getContentPane().add(radMale);
		
		JRadioButton radFemale = new JRadioButton("\u5973");
		radFemale.setBounds(223, 72, 61, 23);
		getContentPane().add(radFemale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radMale);
		group.add(radFemale);
		
		JLabel lblAge = new JLabel("\u5E74\u9F84");
		lblAge.setBounds(79, 117, 36, 23);
		getContentPane().add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setBounds(141, 118, 66, 21);
		getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblAddress = new JLabel("\u5730\u5740");
		lblAddress.setBounds(79, 168, 36, 15);
		getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(141, 165, 210, 21);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				bean.setId(id);
				StudentAction action = new StudentAction();
				int n = action.updateStudent(bean);
				if(n>0)
				{
					JOptionPane.showMessageDialog(null,"修改成功");
					Test.updateBenZhuanDialog.dispose();
				}
			}
		});
		button.setBounds(159, 212, 93, 23);
		getContentPane().add(button);
		
		StudentAction actioin = new StudentAction();
		StudentBean bean = actioin.selectById(id);
		txtName.setText(bean.getName());
		if(bean.getSex().equals("男"))
		{
			radMale.setSelected(true);
		}else
		{
			radFemale.setSelected(true);
		}
		txtAge.setText(bean.getAge()+"");
		txtAddress.setText(bean.getAddress());
		
	}
}
