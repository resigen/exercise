package com.javaeasy.learncomponent;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
public class a {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800,800);
		frame.setLocation(new Point(100,300));
		frame.setTitle("ѧϰSwing�Ĳ��ֹ�����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		BorderLayout layout = new BorderLayout();
		
		container.setLayout(layout);
		JButton btn1 = new JButton("�ұ�һ��mua��");
		JButton btn2 = new JButton("���һ��mua��");
		JButton btn3 = new JButton("�ϱ�һ��mua��");
		JButton btn4 = new JButton("�±�һ��mua��");
		JButton btn5 = new JButton("���ľ����㣨�У�");
		container.add(btn1,BorderLayout.EAST);
		container.add(btn2,BorderLayout.WEST);
		container.add(btn3,BorderLayout.SOUTH);
		container.add(btn4,BorderLayout.NORTH);
		container.add(btn5,BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
}
