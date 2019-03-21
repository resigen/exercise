package com.zhuoshi.view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zhuoshi.action.BenkeShengyuanAction;
import com.zhuoshi.action.WJAction;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.WJBean;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class WenTiDialog extends JDialog {
	private JTextField txtwenti;
	private Choice cobXinXi;

	public WenTiDialog(WJBean w) {
		this.setModal(true);
		setBounds(100, 100,422,379);
		getContentPane().setLayout(null);
		
		JLabel lblwenti = new JLabel("\u95EE\u9898");
		lblwenti.setBounds(51, 83, 54, 15);
		getContentPane().add(lblwenti);
		
		txtwenti = new JTextField();
		txtwenti.setEnabled(false);
		txtwenti.setBounds(104, 80, 217, 21);
		getContentPane().add(txtwenti);
		txtwenti.setColumns(10);
		
		cobXinXi = new Choice();
		cobXinXi.setBounds(104, 165, 217, 21);
		getContentPane().add(cobXinXi);
		
		JLabel lbldaan = new JLabel("\u7B54\u6848");
		lbldaan.setBounds(51, 171, 54, 15);
		getContentPane().add(lbldaan);
		
		JButton button = new JButton("\u4E0B\u4E00\u9898");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Test.wtDialog.dispose();

			}
		});
		button.setBounds(158, 262, 93, 23);
		getContentPane().add(button);
		
		txtwenti.setText(w.getWenti());
		cobXinXi.add(w.getDaan1());
		cobXinXi.add(w.getDaan2());
		cobXinXi.add(w.getDaan3());
		
		
	}
}
