package com.javaeasy.learncomponent;

import java.awt.Container;
import java.awt.Point;

import javax.swing.JFrame;

public class firstJFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600, 300);
		frame.setLocation(new Point(100, 100));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		frame.setVisible(true);
	}
}