package com.javaeasy.learncomponent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
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
		JComboBox combo = new JComboBox(new Object[] {"爱我","不爱我"});
		combo.addItem("喜欢我");
		combo.setSelectedIndex(0);
		Object obj = combo.getSelectedItem();
		System.out.println("你对我的感情是："+obj);
		container.add(combo);
		frame.setVisible(true);
		
	}
}
