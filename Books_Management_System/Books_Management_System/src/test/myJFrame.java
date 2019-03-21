package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class myJFrame extends JFrame{

	JMenuItem add=new JMenuItem("添加书籍");
	JMenuItem mge=new JMenuItem("管理书籍");
	JMenuItem bor=new JMenuItem("借书");
	JMenuItem rebo=new JMenuItem("还书");
	
	JMenu fileMenu=new JMenu("管理");
	
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
	
		this.setTitle("书籍管理系统");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
	
		add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				addbooks();
			}
		});
		mge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				managebook();
			}
		});
		bor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				borrowbook();
			}
		});
		rebo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
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
