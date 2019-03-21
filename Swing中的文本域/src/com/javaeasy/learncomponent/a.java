package com.javaeasy.learncomponent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class a {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800,800);
		frame.setLocation(new Point(100,300));
		frame.setTitle("学习Swing的组件");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		
		FlowLayout layout = new FlowLayout();
		container.setLayout(layout);
		JTextArea area = new JTextArea();
		area.setRows(7);
		area.setColumns(20);
		area.setText("这是一个文本域");
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(area);
		container.add(scroll);
		frame.setVisible(true);
		
	}
}
