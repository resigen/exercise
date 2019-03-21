package com.javaeasy.learncomponent;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class a {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800,800);
		frame.setLocation(new Point(100,300));
		frame.setTitle("这是一个窗口");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		GridBagLayout layout = new GridBagLayout();
		container.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		JButton btn1 = new JButton("爱你");
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.ORANGE);
		JButton btn2 = new JButton("更爱你");
		JButton btn3 = new JButton("更更爱你");
		JPanel panel2 =new JPanel();
		panel2.setBackground(Color.BLUE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.NONE;
		container.add(btn1,gbc);
		gbc.gridx = 1;
		container.add(panel1,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth =2;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		container.add(btn2,gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 0;
		gbc.weighty = 0;
		container.add(btn3,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		container.add(panel2,gbc);
		frame.setVisible(true);
		
	}
}
