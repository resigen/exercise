package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class myJFrame extends JFrame{

	JMenuItem add=new JMenuItem("����鼮");
	JMenuItem mge=new JMenuItem("�����鼮");
	JMenuItem bor=new JMenuItem("����");
	JMenuItem rebo=new JMenuItem("����");
	
	JMenu fileMenu=new JMenu("����");
	
	JMenuBar jmb=new JMenuBar();
	
	public myJFrame()
	{
		try {

		} catch (Exception e) {
			e.printStackTrace();
			}
		fileMenu.add(add);
		fileMenu.add(mge);
		fileMenu.add(bor);
		fileMenu.add(rebo);
		
		jmb.add(fileMenu);

		this.setJMenuBar(jmb);
	
		this.setTitle("�鼮����ϵͳ");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
	
		add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				addbooks();
			}
		});
		mge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				managebook();
			}
		});
		bor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				borrowbook();
			}
		});
		rebo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				givebook();
			}
		});
	}
	
	public void addbooks(){
		addbooks in=new addbooks();
	}
	
	public void managebook(){
		manage show=new manage();
		
	}
	
	public void borrowbook(){
		borrow show=new borrow();
		
	}
	
	public void givebook(){
		give_back show=new give_back();
		
	}
	
}
