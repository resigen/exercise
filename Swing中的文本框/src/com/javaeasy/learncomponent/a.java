package com.javaeasy.learncomponent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class a {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800,800);
		frame.setLocation(new Point(100,300));
		frame.setTitle("ѧϰSwing�����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		
		FlowLayout layout = new FlowLayout();
		container.setLayout(layout);
		JTextField txt = new JTextField();
		txt.setText("����һ���ı���");
		container.add(txt);
		frame.setVisible(true);
		try {
			Thread.sleep(10000);
			String content = txt.getText();
			System.out.println(content);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
