package com.javaeasy.learncomponent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class a {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300,100);
		frame.setLocation(new Point(100,300));
		frame.setTitle("ѧϰSwing�����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		
		FlowLayout layout = new FlowLayout();
		container.setLayout(layout);
		JLabel label = new JLabel();
		label.setText("����һ����ǩ");
		container.add(label);
		frame.setVisible(true);
		try {
			Thread.sleep(5000);
			label.setEnabled(false);
			Thread.sleep(5000);
			label.setVisible(false);
			Thread.sleep(5000);
			label.setVisible(true);
			Thread.sleep(5000);
			label.setEnabled(true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
