package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.UserDAO;
import Dao.booklistDAO;
import entity.Users;
import entity.booklist;

	public class give_back extends JFrame {
		
		

		String data[][]=new String[0][0];
	    String names[]={"编号","书籍","价格","作者","出版时间","出版社","是否借出"};	           
		
		//String data[][]=new String[3][3];
		
		//String data[][]={ {},{},{} };
		
		JTextField txt=new JTextField();
		
		JButton btn=new JButton("查询");
		JButton giveBtn=new JButton("归还");
		
		
		//必须放在JScrollPane中
		JTable jt=new JTable(data,names);
		
		JScrollPane jsp=new JScrollPane(jt);
		
		public give_back()
		{
			txt.setBounds(10, 10,150,30);
			btn.setBounds(170, 10,70, 30);
			
			jsp.setBounds(10, 50,400,100);
			
			giveBtn.setBounds(10, 160,70,30);
			
		
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					query();
					
				}
			});
			
			
			giveBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					give();
				}
			});


			
			//jt.getTableHeader().setReorderingAllowed(false);
			this.getContentPane().setLayout(null);
			this.getContentPane().add(txt);
			this.getContentPane().add(btn);
			this.getContentPane().add(jsp);
			this.getContentPane().add(giveBtn);
			
			
			
			this.setSize(600,600);
			
			this.setVisible(true);
			
		}
		public void query()
		{
			//获取文本框的值
			String name=txt.getText();
			//使用这个值 作为查询条件  查询所有匹配的users
			booklistDAO dao=new booklistDAO();
			
			
			ArrayList<booklist> bookList=dao.getbooklistByName(name);
			
			//将bookList中的数据 添加到表格中
			
//			表格中---内容 （二维数组） 标题（一维数组）
			//将集合中的内容 转换为 二维数组
			
			Object contents[][]=new Object[bookList.size()][7];
			
		
			
			for(int i=0;i<bookList.size();i++)
			{
				booklist u=bookList.get(i);
				contents[i][0]=u.getId();
				contents[i][1]=u.getName();
				contents[i][2]=u.getprice();
				contents[i][3]=u.getauth();
				contents[i][4]=u.getpub_date();
				contents[i][5]=u.getpress();
				contents[i][6]=u.getstates();
			}
			
			//创建一个表格的模型
			DefaultTableModel dtm=new DefaultTableModel(contents, names);
			
			
			jt.setModel(dtm);
			
		}
		
		
		public void give()
		{
			//1.获取选中那一行的第一个单元格的值
			
			int row=jt.getSelectedRow();
			if(row==-1)
			{
				JOptionPane.showMessageDialog(this,  "请选择您要归还的书","错误消息", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
		
			
			int id=(Integer)jt.getValueAt(row, 0);
			System.out.println(id);
			
			String flag2="是",flag1;
			flag1=jt.getValueAt(row, 6).toString();
			if(flag1.equals(flag2)) {
				
				booklistDAO dao=new booklistDAO();
				
				boolean flag=dao.repair(id);
				
				if(flag)
				{
					JOptionPane.showMessageDialog(this,"归还成功", "删除",  JOptionPane.ERROR_MESSAGE);
					query();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"归还失败",  "删除", JOptionPane.ERROR_MESSAGE);
					query();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"归还失败",  "删除", JOptionPane.ERROR_MESSAGE);
				query();
			}
			
		}
		
	
	}


