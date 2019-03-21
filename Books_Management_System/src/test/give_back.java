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
	    String names[]={"���","�鼮","�۸�","����","����ʱ��","������","�Ƿ���"};	           
		
		//String data[][]=new String[3][3];
		
		//String data[][]={ {},{},{} };
		
		JTextField txt=new JTextField();
		
		JButton btn=new JButton("��ѯ");
		JButton giveBtn=new JButton("�黹");
		
		
		//�������JScrollPane��
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
			//��ȡ�ı����ֵ
			String name=txt.getText();
			//ʹ�����ֵ ��Ϊ��ѯ����  ��ѯ����ƥ���users
			booklistDAO dao=new booklistDAO();
			
			
			ArrayList<booklist> bookList=dao.getbooklistByName(name);
			
			//��bookList�е����� ��ӵ������
			
//			�����---���� ����ά���飩 ���⣨һά���飩
			//�������е����� ת��Ϊ ��ά����
			
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
			
			//����һ������ģ��
			DefaultTableModel dtm=new DefaultTableModel(contents, names);
			
			
			jt.setModel(dtm);
			
		}
		
		
		public void give()
		{
			//1.��ȡѡ����һ�еĵ�һ����Ԫ���ֵ
			
			int row=jt.getSelectedRow();
			if(row==-1)
			{
				JOptionPane.showMessageDialog(this,  "��ѡ����Ҫ�黹����","������Ϣ", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
		
			
			int id=(Integer)jt.getValueAt(row, 0);
			System.out.println(id);
			
			String flag2="��",flag1;
			flag1=jt.getValueAt(row, 6).toString();
			if(flag1.equals(flag2)) {
				
				booklistDAO dao=new booklistDAO();
				
				boolean flag=dao.repair(id);
				
				if(flag)
				{
					JOptionPane.showMessageDialog(this,"�黹�ɹ�", "ɾ��",  JOptionPane.ERROR_MESSAGE);
					query();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"�黹ʧ��",  "ɾ��", JOptionPane.ERROR_MESSAGE);
					query();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"�黹ʧ��",  "ɾ��", JOptionPane.ERROR_MESSAGE);
				query();
			}
			
		}
		
	
	}


