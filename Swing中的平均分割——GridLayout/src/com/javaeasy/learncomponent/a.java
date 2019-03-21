package com.javaeasy.learncomponent;

import java.awt.Container;
import java.awt.GridLayout;
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

public class a {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		menuBar.add(new JMenu("这是一个爱心菜单"));
		frame.setSize(800,800);
		frame.setLocation(new Point(100,300));
		frame.setTitle("这是一个窗口");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout (new GridLayout(3,2));
		container.add(new JLabel("这是一个标签，可以用来显示文字"));
		container.add(new JTextField("这是一个文本框"));
		container.add(new JComboBox(new Object[] {"这是组合框，选则下拉条目。"}));
		container.add(new JButton("这是按钮"));
		frame.setVisible(true);
		
	}
}
