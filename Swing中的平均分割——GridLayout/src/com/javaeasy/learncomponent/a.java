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
		menuBar.add(new JMenu("����һ�����Ĳ˵�"));
		frame.setSize(800,800);
		frame.setLocation(new Point(100,300));
		frame.setTitle("����һ������");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout (new GridLayout(3,2));
		container.add(new JLabel("����һ����ǩ������������ʾ����"));
		container.add(new JTextField("����һ���ı���"));
		container.add(new JComboBox(new Object[] {"������Ͽ�ѡ��������Ŀ��"}));
		container.add(new JButton("���ǰ�ť"));
		frame.setVisible(true);
		
	}
}
